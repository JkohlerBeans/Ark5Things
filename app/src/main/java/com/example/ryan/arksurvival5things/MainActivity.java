package com.example.ryan.arksurvival5things;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    public void wikiLinks(View view) {
        // takes user to Ark Survival Evolved Wiki page if they have a web browser installed
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://ark.gamepedia.com/ARK:_Survival_Evolved_Wiki"));
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void recipeButtonClick(View view) {

        //get the person's entered name from the EditText
        EditText nameBox = (EditText) findViewById(R.id.namebox);
        String name = nameBox.getText().toString();

        //get the values of the checkboxes
        CheckBox campfireCheckBox = (CheckBox) findViewById(R.id.campfireCheckbox);
        Boolean campfireBool = campfireCheckBox.isChecked();

        CheckBox bedCheckBox = (CheckBox) findViewById(R.id.bedCheckbox);
        Boolean bedBool = bedCheckBox.isChecked();

        CheckBox pickCheckBox = (CheckBox) findViewById(R.id.pickCheckbox);
        Boolean pickBool = pickCheckBox.isChecked();

        CheckBox hatchetCheckBox = (CheckBox) findViewById(R.id.hatchetCheckbox);
        Boolean hatchetBool = hatchetCheckBox.isChecked();

        CheckBox torchCheckBox = (CheckBox) findViewById(R.id.torchCheckbox);
        Boolean torchBool = torchCheckBox.isChecked();

        //create integer values to store total amount of each resource
        int totalWood = 0;
        int totalThatch = 0;
        int totalStone = 0;
        int totalFlint = 0;
        int totalFiber = 0;
        int totalHide = 0;

        //if a recipe is selected, update the int values for resources
        if (campfireBool) {
            totalWood += 2;
            totalThatch += 12;
            totalStone += 16;
            totalFlint += 1;
        }
        if (bedBool) {
            totalThatch += 80;
            totalWood += 15;
            totalFiber += 30;
            totalHide += 40;
        }
        if (pickBool) {
            totalStone += 1;
            totalWood += 1;
            totalThatch += 10;
        }
        if (hatchetBool) {
            totalFlint += 1;
            totalWood += 1;
            totalThatch += 10;
        }
        if (torchBool) {
            totalFlint += 1;
            totalWood += 1;
            totalStone += 1;
        }

        //if at least one checkbox is selected, display the message to username
        TextView messageView = (TextView) findViewById(R.id.resourceMessage);
        if (campfireBool || bedBool || pickBool || hatchetBool || torchBool) {
            messageView.setText(name + " you will need:");
        } else {
            messageView.setText("");
        }


        //make the wood resource views editable
        TextView woodValueView = (TextView) findViewById(R.id.woodValue);
        TextView woodNameView = (TextView) findViewById(R.id.woodName);
        ImageView woodIconView = (ImageView) findViewById(R.id.woodIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalWood > 0) {
            String wood = "" + totalWood;
            woodValueView.setText(wood);
            woodNameView.setText("Wood");
            woodIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            woodValueView.setText("");
            woodNameView.setText("");
            woodIconView.setVisibility(View.GONE);
        }

        //make the thatch resource views editable
        TextView thatchValueView = (TextView) findViewById(R.id.thatchValue);
        TextView thatchNameView = (TextView) findViewById(R.id.thatchName);
        ImageView thatchIconView = (ImageView) findViewById(R.id.thatchIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalThatch > 0) {
            String thatch = "" + totalThatch; //I'm a dummy and couldn't figure out how to convert this int to string
            thatchValueView.setText(thatch);
            thatchNameView.setText("Thatch");
            thatchIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            thatchValueView.setText("");
            thatchNameView.setText("");
            thatchIconView.setVisibility(View.GONE);
        }

        //make the stone resource views editable
        TextView stoneValueView = (TextView) findViewById(R.id.stoneValue);
        TextView stoneNameView = (TextView) findViewById(R.id.stoneName);
        ImageView stoneIconView = (ImageView) findViewById(R.id.stoneIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalStone > 0) {
            String stone = "" + totalStone; //I'm a dummy and couldn't figure out how to convert this int to string
            stoneValueView.setText(stone);
            stoneNameView.setText("Stone");
            stoneIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            stoneValueView.setText("");
            stoneNameView.setText("");
            stoneIconView.setVisibility(View.GONE);
        }

        //make the flint resource views editable
        TextView flintValueView = (TextView) findViewById(R.id.flintValue);
        TextView flintNameView = (TextView) findViewById(R.id.flintName);
        ImageView flintIconView = (ImageView) findViewById(R.id.flintIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalFlint > 0) {
            String flint = "" + totalFlint; //I'm a dummy and couldn't figure out how to convert this int to string
            flintValueView.setText(flint);
            flintNameView.setText("Flint");
            flintIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            flintValueView.setText("");
            flintNameView.setText("");
            flintIconView.setVisibility(View.GONE);
        }

        //make the fiber resource views editable
        TextView fiberValueView = (TextView) findViewById(R.id.fiberValue);
        TextView fiberNameView = (TextView) findViewById(R.id.fiberName);
        ImageView fiberIconView = (ImageView) findViewById(R.id.fiberIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalFiber > 0) {
            String fiber = "" + totalFiber; //I'm a dummy and couldn't figure out how to convert this int to string
            fiberValueView.setText(fiber);
            fiberNameView.setText("Fiber");
            fiberIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            fiberValueView.setText("");
            fiberNameView.setText("");
            fiberIconView.setVisibility(View.GONE);
        }

        //make the hide resource views editable
        TextView hideValueView = (TextView) findViewById(R.id.hideValue);
        TextView hideNameView = (TextView) findViewById(R.id.hideName);
        ImageView hideIconView = (ImageView) findViewById(R.id.hideIcon);

        //if the resource is used, update the hidden views to show required amount
        if (totalHide > 0) {
            String hide = "" + totalHide; //I'm a dummy and couldn't figure out how to convert this int to string
            hideValueView.setText(hide);
            hideNameView.setText("Hide");
            hideIconView.setVisibility(View.VISIBLE);
        } else {
            //remove views if resource not used
            hideValueView.setText("");
            hideNameView.setText("");
            hideIconView.setVisibility(View.GONE);
        }

    }
}
