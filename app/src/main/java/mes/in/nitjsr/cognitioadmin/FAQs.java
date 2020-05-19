package mes.in.nitjsr.cognitioadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import static mes.in.nitjsr.cognitioadmin.MainActivity.EMAIL;
import static mes.in.nitjsr.cognitioadmin.MainActivity.NAME;

public class FAQs extends AppCompatActivity {

    EditText etQues,etAns;
    String ques,ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);
        etQues=findViewById(R.id.notif_body);
        etAns=findViewById(R.id.notif_header);

        Log.d("hello",EMAIL+NAME);

        findViewById(R.id.push).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ques=etQues.getText().toString();
                ans=etAns.getText().toString();
                if(!(TextUtils.isEmpty(ques))&&!(TextUtils.isEmpty(ans))){


                    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                    String key = databaseReference.child("Notifications").push().getKey();
                    ExpandableListModal notifs = new ExpandableListModal(ans.trim(),ques.trim(),NAME,EMAIL);
                    Map<String, Object> postValues = notifs.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put(key,postValues);
                    databaseReference.child("FAQs").updateChildren(childUpdates);

                    etAns.setText("");
                    etQues.setText("");
                }
                else{
                    Toast.makeText(FAQs.this,"Fields cannot be empty!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
