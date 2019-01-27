package xiahuapchat.com.xiahua;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iflide.vr.UnityTheEntrance.TestClass;
import com.iflide.vr.UnityTheEntrance.VrApplication;

public class MainActivity extends AppCompatActivity {
    private  EditText edit_query;
    private  TextView shortcut;
    private TextView result;
    private Button startSearch;
    private  TestClass testClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_query=findViewById(R.id.edit_query);
        result=findViewById(R.id.result);
        edit_query=findViewById(R.id.edit_query);
        startSearch=findViewById(R.id.startSearch);
        startSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edit_query.getText().toString())){
                    Toast.makeText(MainActivity.this,"请输入你要查询的字母组合",Toast.LENGTH_LONG).show();
                }else{
                    result.setText(testClass.WordSearchingInterface(edit_query.getText().toString(), VrApplication.SD_PATH));
                }
            }
        });
        testClass=new TestClass();
    }
}
