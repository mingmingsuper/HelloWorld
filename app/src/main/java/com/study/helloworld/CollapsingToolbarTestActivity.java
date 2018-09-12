package com.study.helloworld;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CollapsingToolbarTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_test);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView fruitImageView = findViewById(R.id.fruit_image_view);
        TextView fruitContentText = findViewById(R.id.fruit_content_text);
        Glide.with(this).load("https://www.liuandy.cn/wp-content/uploads/2017/12/IMG_6559-1024x768.jpg").into(fruitImageView);
        fruitContentText.setText("击壤歌是一首淳朴的民谣。据《帝王世纪》记载：“帝尧之世，天下大和，百姓无事。有八九十老人，击壤而歌。”这位八九十岁的老人所歌的歌词就是：“日出而作，日入而息。凿井而饮，耕田而食。帝力于我何有哉？”也就是我们今天所看到的《击壤歌》。\n" +
                "\n" +
                "　　这首民谣描绘的是在上古尧时代的太平盛世，人们过着无忧无虑的生活，太阳出来就开始干活，太阳落下就回家休息，开凿井泉就有水饮，耕种田地就有饭吃……这反映了农耕文化的显著特点，是劳动人民自食其力的生活的真实写照。\n" +
                "\n" +
                "　　对于这首歌谣的最后一句，“帝力于我何有哉”，“帝力”历来有两种解释。一种认为指“帝王的力量”，也就是说，人们的自给自足、衣食无忧的生活是靠自己的劳动得来的，而君王对此并没有什么作用，歌者反问：帝王的力量对我来说又有什么作用呢？当然，如此闲适安康的生活，并不是真的与帝王一点儿关系都没有，因此也有评论云：“能使民安其作息、饮食即帝力也。得末句翻空一宕，调便流逸。”另一种解释是把“帝力”解释为“天帝的力量”，从而突出了此歌谣反对“天命论”的色彩，歌者感叹：老天爷对我来说有什么用呢？\n" +
                "\n" +
                "　　不管持哪一种解释，这首民歌的主题都是赞颂劳动，藐视“帝力”。\n" +
                "\n" +
                "　　《击壤歌》也许是中国歌曲之祖。清人沈德潜《古诗源》注释说：“帝尧以前，近于荒渺。虽有《皇娥》、《白帝》二歌，系王嘉伪撰，其事近诬。故以《击壤歌》为始。”");
        collapsingToolbar.setTitle("水果名称");
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
