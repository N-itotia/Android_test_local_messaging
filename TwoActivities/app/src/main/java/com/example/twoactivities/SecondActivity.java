package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;



public class SecondActivity extends AppCompatActivity {
    public static final	String	EXTRA_REPLY="com.example.android.twoactivities.extra.REPLY";
    private TextView myTextView;
    private EditText mReply;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply	=	(EditText)	findViewById(R.id.editText_main);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        myTextView = findViewById(R.id.text_message);
        myTextView.setText(message);




    }
    public	void	returnReply(View view)
    {String	reply	=	mReply.getText().toString();
        Intent	replyIntent	=	new	Intent();
        replyIntent.putExtra(EXTRA_REPLY,	reply);
        setResult(RESULT_OK,	replyIntent);
        finish();
    }
}
