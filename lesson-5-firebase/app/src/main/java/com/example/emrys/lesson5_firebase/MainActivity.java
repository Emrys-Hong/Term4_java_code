package import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emrys.lesson5_firebase.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

;
//TODO 10 PUT IN YOUR OWN PACKAGE STATEMENT

public class MainActivity extends AppCompatActivity {

    Button buttonPart1;
    Button buttonPart2AddPicture;
    Button buttonPart2GetPicture;
    ImageView imageViewPart2;
    String TAG = "my firebase app";

    //TODO 10.1 Get a reference to the root node of the firebase database
    DatabaseReference mRootDatabaseRef = FirebaseDatabase.getInstance().getReference();

    //TODO 10.6 Get a reference to the root note of the firebase storage
    StorageReference storageReference = FirebaseStorage.getInstance().getReference();

    DatabaseReference databaseReferencePart1;
    DatabaseReference databaseReferencePart2;
    DatabaseReference databaseReferenceSampleNodeValue;
    ArrayList<String> randomStrings;

    String CHILD_NODE_PART1 = "Part1";
    String CHILD_NODE_PART2 = "Part2";

    String SAMPLE_NODE  = "Pokemon";
    TextView textViewSampleNodeValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 10.0 Example
        textViewSampleNodeValue = findViewById(R.id.textViewSampleNodeValue);
        databaseReferenceSampleNodeValue = mRootDatabaseRef.child(SAMPLE_NODE);
        databaseReferenceSampleNodeValue.setValue("Psyduck");

        databaseReferenceSampleNodeValue.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        textViewSampleNodeValue.setText((String) dataSnapshot.getValue());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );


        //TODO 10.2 initialize the array of strings
        randomStrings = new ArrayList<>();
        randomStrings.add("Mozart");
        randomStrings.add("Ada lovelace");
        randomStrings.add("Beethoven");
        randomStrings.add("Heifetz");
        //TODO 10.3 get a reference to the child node
        databaseReferencePart1 = mRootDatabaseRef.child(CHILD_NODE_PART1);

        //TODO 10.4 Get a reference to the “Add a Random Word” button, set up the OnClickListener and upload a random word to firebase.
        buttonPart1 = findViewById(R.id.buttonPart1);
        buttonPart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int position = random.nextInt( randomStrings.size());
                String oneString = randomStrings.get(position);

                DatabaseReference d = databaseReferencePart1.child("1");
                d.setValue(oneString);
                databaseReferencePart1.push().setValue(oneString);
            }
        });

        //TODO 10.8 Build a HashMap object with your data
        final Map<String, ImageData> imageDataMap = new HashMap<>();
        imageDataMap.put("Pikachu", new ImageData("pikachu", "pokemon"));
        imageDataMap.put("Miku", new ImageData("hatsunemiku", "vocaloid"));
        imageDataMap.put("Totoro", new ImageData("totoro", "Studio Ghibli"));
        //TODO 10.9 Get reference to the root of the child node part 2
        databaseReferencePart2 = mRootDatabaseRef.child(CHILD_NODE_PART2);
        //TODO 10.10 Get reference to the Add Pictures button and write code to upload the HashMap data when button is clicked
        //TODO 10.11  Loop through each entry in the hashmap and do the necessary to upload the image to firebase
        buttonPart2AddPicture = findViewById(R.id.buttonPart2AddPicture);
        buttonPart2AddPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReferencePart2.setValue(imageDataMap);
                for (String key: imageDataMap.keySet()) {
                    ImageData imageData = imageDataMap.get(key);
                    String filename = imageData.filename;
                    String path = "images/" + filename + ".jpg";
                    uploadFileToFirebaseStorage(filename, path);
                    databaseReferencePart2.child(key).child("path").setValue(path);
                }
            }
        });
        //TODO 10.12 Get a reference to the widgets and write code to download an image randomly when the Get Picture button is clicked




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
        //TODO 10.5 invoke addValueEventListener on databaseReferencePart1
        //TODO 10.5 get a reference to the LinearLayoutpart1 and dynanmicaly
        databaseReferencePart1.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                LinearLayout linearLayout = findViewById(R.id.linearLayoutPart1);
                linearLayout.removeAllViews();

                for (DataSnapshot ds: dataSnapshot.getChildren()) {
                    String value = (String) ds.getValue();
                    Log.i(TAG, "key: " + ds.getKey());
                    Log.i(TAG, "value: " + ds.getValue());
                    TextView textView = new TextView(MainActivity.this);
                    textView.setText(value);
                    linearLayout.addView(textView);
                }
            }
        })



    }

    //TODO 10.7 Write a static inner class for Part2

    static class ImageData{

        String filename;
        String description;

        ImageData(String filename, String description){
            this.filename = filename;
            this.description = description;

        }
    }

    void uploadFileToFirebaseStorage(String name, String path){

        int resID = getResources().getIdentifier(name , "drawable", getPackageName());

        Bitmap bitmap = BitmapFactory.decodeResource(
                MainActivity.this.getResources(),
                resID);

        Log.i(TAG, "Res ID " + resID);
        Log.i(TAG, "Bitmap " + bitmap.toString());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] data = byteArrayOutputStream.toByteArray();

        StorageReference imageRef = storageReference.child(path);

        UploadTask uploadTask = imageRef.putBytes(data);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,
                        "cannot upload",
                        Toast.LENGTH_LONG).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(MainActivity.this,
                        "upload success",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    void downloadFromFirebaseStorage(String path, final ImageView imageView){

        final StorageReference imageRef = storageReference.child(path);

        final long ONE_MB = 1024*1024;
        imageRef.getBytes(ONE_MB).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {

                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this,
                        "cannot download",
                        Toast.LENGTH_LONG).show();
            }
        });
    }



}
