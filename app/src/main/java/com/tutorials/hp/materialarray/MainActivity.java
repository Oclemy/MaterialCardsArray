package com.tutorials.hp.materialarray;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import com.dexafree.materialList.card.Card;
import com.dexafree.materialList.card.CardProvider;
import com.dexafree.materialList.card.OnActionClickListener;
import com.dexafree.materialList.card.action.TextViewAction;
import com.dexafree.materialList.view.MaterialListView;
import com.squareup.picasso.RequestCreator;
/*
- Our MainActivity.
- Derives from AppCompatActivity, which is a Base class for activities that use the support library action bar features.
- Inflates ActivityMain.xml layout using setContentView() method.
- Views shown include a GridView.
- Methods: onCreate(),initialViews(),createCard(),getData().
- The purpose of this activity is to create an Array of Cards with title,description,images and action button and add them to material list.

 */
public class MainActivity extends AppCompatActivity {

    MaterialListView materialListView;

    /*
    - When activity is created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initializeViews();
        this.bindData();
    }

    /*
    - Initialize Material ListView.
     */
    private void initializeViews()
    {
        materialListView= (MaterialListView) findViewById(R.id.material_listview);
    }

    /*
    - Bind data to Material ListView.
     */
    private void bindData() {
        for (Galaxy g : getData()) {
            this.createCard(g);
        }
    }
    /*
    - Create a CardView with title,description, image and image.
     */
    private void createCard(final Galaxy g){
        Card card = new Card.Builder(this)
                .withProvider(new CardProvider())
                .setLayout(R.layout.material_basic_image_buttons_card_layout)
                .setTitle(g.getName())
                .setTitleGravity(Gravity.END)
                .setDescription(g.getDescription())
                .setDescriptionGravity(Gravity.END)
                .setDrawable(g.getImage())
                .setDrawableConfiguration(new CardProvider.OnImageConfigListener() {
                    @Override
                    public void onImageConfigure(@NonNull RequestCreator requestCreator) {
                        //requestCreator.fit();
                        requestCreator.resize(121,121);
                    }
                })
                .addAction(R.id.left_text_button, new TextViewAction(this)
                        .setText("Button 1")
                        .setTextResourceColor(R.color.colorAccent)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Toast.makeText(getApplicationContext(), "Right button on card " +g.getName(), Toast.LENGTH_SHORT).show();
                            }
                        }))
                .addAction(R.id.right_text_button, new TextViewAction(this)
                        .setText("Button 2")
                        .setTextResourceColor(R.color.orange_button)
                        .setListener(new OnActionClickListener() {
                            @Override
                            public void onActionClicked(View view, Card card) {
                                Toast.makeText(getApplication(), "Right button on card " + card.getProvider().getDescription(), Toast.LENGTH_SHORT).show();
                            }
                        }))
                .endConfig()
                .build();

        // Add Card to ListView
        materialListView.getAdapter().add(card);
    }

    /*
    - Our data source
     */
    private Galaxy[] getData()
    {
        Galaxy[] galaxies = new Galaxy[10];

        Galaxy g=new Galaxy("Whirlpool",
                "The Whirlpool Galaxy, also known as Messier 51a, M51a, and NGC 5194, is an interacting grand-design spiral galaxy with a Seyfert 2 active galactic nucleus in the constellation Canes Venatici.",
                R.drawable.whirlpool);
        galaxies[0]=g;

        g=new Galaxy("Triangulumn",
                "The Triangulum Galaxy is a spiral galaxy approximately 3 million light-years from Earth in the constellation Triangulum",
                R.drawable.triangulum);
        galaxies[1]=g;

        g=new Galaxy("Milky Way",
                "The Milky Way is the galaxy that contains our Solar System." +
                " The descriptive milky is derived from the appearance from Earth of the galaxy – a band of light seen in the night sky formed from stars",
                R.drawable.milkyway);
        galaxies[2]=g;

        g=new Galaxy("Andromeda",
                "The Andromeda Galaxy, also known as Messier 31, M31, or NGC 224, is a spiral galaxy approximately 780 kiloparsecs from Earth. It is the nearest major galaxy to the Milky Way and was often referred to as the Great Andromeda Nebula in older texts.",
                R.drawable.andromeda);
        galaxies[3]=g;

        g=new Galaxy("StarBust",
                "A starburst galaxy is a galaxy undergoing an exceptionally high rate of star formation, as compared to the long-term average rate of star formation in the galaxy or the star formation rate observed in most other galaxies. ",
                R.drawable.starbust);
        galaxies[4]=g;

        g=new Galaxy("Messier 81",
                "Messier 81 is a spiral galaxy about 12 million light-years away in the constellation Ursa Major. Due to its proximity to Earth, large size and active galactic nucleus, Messier 81 has been studied extensively by professional astronomers.",
                R.drawable.messier81);
        galaxies[5]=g;

        g=new Galaxy("Sombrero",
                "Sombrero Galaxy is an unbarred spiral galaxy in the constellation Virgo located 31 million light-years from Earth. The galaxy has a diameter of approximately 50,000 light-years, 30% the size of the Milky Way.",
                R.drawable.sombrero);
        galaxies[6]=g;

        g=new Galaxy("Pinwheel",
                "The Pinwheel Galaxy is a face-on spiral galaxy distanced 21 million light-years away from earth in the constellation Ursa Major. ",
                R.drawable.pinwheel);
        galaxies[7]=g;

        g=new Galaxy("Canis Majos Overdensity",
                "The Canis Major Dwarf Galaxy or Canis Major Overdensity is a disputed dwarf irregular galaxy in the Local Group, located in the same part of the sky as the constellation Canis Major. ",
                R.drawable.canismajoroverdensity);
        galaxies[8]=g;

        g=new Galaxy("Cosmos Redshift",
                "Cosmos Redshift 7 is a high-redshift Lyman-alpha emitter galaxy, in the constellation Sextans, about 12.9 billion light travel distance years from Earth, reported to contain the first stars —formed ",
                R.drawable.cosmosredshift);
        galaxies[9]=g;

        return galaxies;
    }
}
