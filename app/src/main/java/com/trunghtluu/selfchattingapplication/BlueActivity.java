package com.trunghtluu.selfchattingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class BlueActivity extends AppCompatActivity {

    private TextView chat_text_view;

    private ImageView blue_image_view;

    private EditText chatbox_edit_text;
    private Button chatbox_send_button;

    private SharedPreferences sharedPreferences;

    private String conversations;

    private String imageUrl = "https://cdn.dribbble.com/users/1787323/screenshots/4422567/dribbbe_sqrtl-01.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        blue_image_view = findViewById(R.id.blue_image_view);
        Glide.with(this)
                .load(imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(blue_image_view);

        chat_text_view = findViewById(R.id.chat_text_view);
        chat_text_view.setMovementMethod(new ScrollingMovementMethod());

        sharedPreferences = getSharedPreferences(Constants.SHARED_CONVERSATION, Context.MODE_PRIVATE);
        conversations = sharedPreferences.getString(Constants.SHARED_CONVERSATION, "defaultValue");
        chat_text_view.setText(conversations);

        chatbox_edit_text = findViewById(R.id.chatbox_edit_text);
        chatbox_send_button = findViewById(R.id.chatbox_send_button);
        chatbox_send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = Constants.BLUE_NAME + ": "
                        + chatbox_edit_text.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                conversations = conversations + "\n" + message;

                editor.putString(Constants.SHARED_CONVERSATION, conversations);
                editor.commit();

                chat_text_view.setText(conversations);
                chatbox_edit_text.setText(null);
            }
        });
    }
}
