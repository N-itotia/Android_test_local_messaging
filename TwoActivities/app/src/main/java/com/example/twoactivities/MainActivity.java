package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public	static	final	int	TEXT_REQUEST	=	1;
    public static final String EXTRA_MESSAGE="com.example.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    private	TextView mReplyHeadTextView;
    private TextView mReplyTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mReplyHeadTextView	=	(TextView)	findViewById(R.id.text_header_reply);
        mReplyTextView	=	(TextView)	findViewById(R.id.text_message_reply);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
    }

    public void launch_Second_Activity(View view) {

        Intent intent = new Intent(this,SecondActivity.class);
        String message= mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);

        startActivityForResult(intent,	TEXT_REQUEST);

    }
    public	void	onActivityResult(int requestCode,int	resultCode,Intent	data)
    {
        super.onActivityResult(requestCode,	resultCode,	data);
        if	(requestCode	==	TEXT_REQUEST)
        {if	(resultCode	==	RESULT_OK)
        {String	reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
            mReplyHeadTextView.setVisibility(View.VISIBLE);
            mReplyTextView.setText(reply);
            mReplyTextView.setVisibility(View.VISIBLE);
        }
        }
    }
}
