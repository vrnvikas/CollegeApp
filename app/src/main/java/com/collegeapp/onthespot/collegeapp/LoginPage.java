package com.collegeapp.onthespot.collegeapp;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LoginPage extends AppCompatActivity {

    private Toolbar toolbar;

    private LinearLayout mRoot;
    private TextInputLayout mEmailLayout;
    private TextInputLayout mPasswordLayout;
    private EditText mInputEmail;
    private EditText mInputPassword;
    private FloatingActionButton mFAB;
    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
    private View.OnClickListener mFabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar.make(mRoot, "Button Clicked", Snackbar.LENGTH_SHORT)
                    .show();
        }
    };

    public LoginPage() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        mRoot = (LinearLayout) findViewById(R.id.root_layout);
        mEmailLayout = (TextInputLayout) findViewById(R.id.email_layout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        mInputEmail = (EditText) findViewById(R.id.input_email);
        mInputPassword = (EditText) findViewById(R.id.input_password);
        mFAB = (FloatingActionButton) findViewById(R.id.fab);
        mFAB.setOnClickListener(mFabClickListener);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }



        return super.onOptionsItemSelected(item);
    }


    public void submit(View view) {

        boolean isEmptyEmail = isEmptyEmail();
        boolean isEmptyPassword = isEmptyPassword();
        if (isEmptyEmail && isEmptyPassword) {
            Snackbar.make(mRoot, "One Or More Fields Are Blank", Snackbar.LENGTH_SHORT)
                    .setAction(getString(R.string.text_dismiss), mSnackBarClickListener)
                    .show();
        } else if (isEmptyEmail && !isEmptyPassword) {
            mEmailLayout.setError("Email Cannot Be Empty");
            mPasswordLayout.setError(null);
        } else if (!isEmptyEmail && isEmptyPassword) {
            mPasswordLayout.setError("Password Cannot Be Empty");
            mEmailLayout.setError(null);
        } else {
            //All Good Here
        }
    }

    private boolean isEmptyEmail() {
        return mInputEmail.getText() == null
                || mInputEmail.getText().toString() == null
                || mInputEmail.getText().toString().isEmpty();

    }

    private boolean isEmptyPassword() {
        return mInputPassword.getText() == null
                || mInputPassword.getText().toString() == null
                || mInputPassword.getText().toString().isEmpty();

    }

}
