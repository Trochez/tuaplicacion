package org.codimo.tuaplicaicon;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

import static org.codimo.tuaplicaicon.apiMethods.jsonUserSelected;

public class userSelected extends AppCompatActivity {

    //create gui elements
    static TextView tvname;
    static TextView tvnum;
    static TextView tvaddress;
    static ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selected);

        //join gui elements with visual elements
        tvname = findViewById(R.id.name);
        tvnum = findViewById(R.id.tel);
        tvaddress = findViewById(R.id.address);
        iv = findViewById(R.id.picture);

        //start asynchronous thread to get user information object from url
        new HttpAsyncTask().execute("https://randomuser.me/api/");

    }

    //class to create asynchronous thread that get the user information
    public static class HttpAsyncTask extends AsyncTask<String, Void, selectedUser> {
        @Override
        protected selectedUser doInBackground(String... urls) {

            //get user information object
            return jsonUserSelected(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(selectedUser result) {

            //when user information object is ready, set each field in gui elements

            tvname.setText(result.getComposedName());
            tvnum.setText(result.getPhone());
            tvaddress.setText(result.getComposedAddress());

            //start process to set user image from user information picture url
            new DownloadImageTask(iv)
                    .execute(result.getPicture());



        }
    }

    //class to create asynchronous thread that get image from url and set it in imageview of gui
    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        //imageview gui element
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {

                //debug
                System.out.println("------------------ url picture "+urldisplay);

                //get stream from url
                InputStream in = new java.net.URL(urldisplay).openStream();

                //convert stream in bitmap
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                System.err.println("------------------- ERROR image url "+e);
            }

            //return bitmap
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {

            //set bitmap in imageview gui
            bmImage.setImageBitmap(result);
        }
    }
}
