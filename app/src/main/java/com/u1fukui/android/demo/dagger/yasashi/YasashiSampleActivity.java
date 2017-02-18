package com.u1fukui.android.demo.dagger.yasashi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.u1fukui.android.demo.dagger.R;

import javax.inject.Inject;

/**
 * やさしいDagger2
 * http://starzero.hatenablog.com/entry/2016/12/02/084412
 */
public class YasashiSampleActivity extends AppCompatActivity {

    private static final String TAG = YasashiSampleActivity.class.getSimpleName();

    // インスタンスが注入されるフィールド
    @Inject
    Owner owner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // SampleComponentからDaggerSampleComponentが自動生成されるので、それを使ってSampleComponentを作ります。
        SampleComponent component = DaggerSampleComponent.builder()
                // 使用するModuleのインスタンスを指定します。
                // （ここでdeprecatedになることがありますが、一旦すべてコードを書いてビルドすると消えると思います）
                .sampleModule(new SampleModule())
                .build();

        // 依存の注入を実行します
        component.inject(this);

        Log.d(TAG, owner.getPetName());
    }
}
