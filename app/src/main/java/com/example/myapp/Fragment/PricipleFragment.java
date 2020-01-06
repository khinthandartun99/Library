package com.example.myapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.Utils.FontEmbedder;

public class PricipleFragment extends Fragment {
    TextView txtpinciple1,txtprinciple;
//            txtpinciple2,txtpinciple3,txtpinciple4,txtpinciple5,txtpinciple6,txtpinciple7,txtpinciple8,txtpinciple9,txtpinciple10;
 View rootview;
//    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.principle, container, false);
        String principle1="\tစာကြည့်တိုက်အတွင်း လိုက်နာရမည့်ရ\n\t\t\t\t        မည့်စည်းကမ်းချက်များ\n";
        String principle="\t\t၁.  စာအုပ်ငှားသူတိုင်းသည် ငှားခွင့်ကဒ်ပြားများပြုလုပ်ရမည်။"+"\n";
        principle+="\t\t၂.  စာကြည့်တိုက်အတွင်း စာဖတ်ခြင်း၊စာအုပ်ငှားရမ်းသည့်\n\t\t    ကိစ္စများဆာင်ရွက်ရာတွင် ကျယ်‌လောင်စွာစကား‌‌ပြော\n\t\t    ဆိုခြင်း မပြုရ။"+"\n";
        principle+="\t\t၃.  ကိုယ်ပိုင်စာကြည့်တိုက်ကဒ်ကို သုံးမှသာငှားခွင့်ပြုရမည်။"+"\n";
        principle+="\t\t၄.  စာကြည့်တိုက်အတွင်း မိမိယူဆောင်ဖတ်ရှုလေ့လာ\n\t\t    လိုသည့် စာအုပ်များကိုသက်ဆိုင်ရာတာဝန်ရှိသူထံခွင့်\n\t\t    ပြုချက်တောင်းခံပြီးမှသာဖတ်ရှုလေ့လာခွင့်ပြုမည်။ \n\t\t   စာအုပ်များကို သေချာစွာ ပြန်လည်အပ်နှံပြီးမှ ထွက်ခွာ\n\t\t    ရမည်။"+"\n";
        principle+="\t\t၅.  စာအုပ်များကို တစ်ကြိမ်ငှားလျှင် \n\t\t    စာအုပ်(၂)အုပ်သာ ငှားယူနိုင်ပါသည်။ ဘာသာရပ်ဆိုင်ရာ \n\t\t\t   စာအုပ်များကို ငှားရာတွင် (၅)ရက်သာငှားခွင့်ရှိသည်။"+"\n";
        principle+="\t\t၆.  မိမိငှားယူထားသောစာအုပ်များကို ပြန်အပ်ရက်စေ့သော်\n\t\t    ချက်ချင်းပြန်အပ်ရမည်။မပြီးသေးပါက ထပ်မံရက်တိုး\n\t\t    ငှားရန်း ယူနိုင်သည်။"+"\n";
        principle+="\t\t၇.  စာအုပ်များကို ရိုသေစွာကိုင်တွယ်ရမည်။ ရေးခြစ်မှတ်\n\t\t    သားခြင်း လုံးဝလုံးဝခွင့်မပြု။ စာအုပ်များ ပျက်စီးခြင်းမရှိ\n\t\t    စေရန် ဂရုပြုရမည်။"+"\n";
        principle+="\t\t၈.  စာအုပ်များပျောက်ဆုံးပျက်ဆီးပါက စာအုပ်တန်ဖိုး၏ \n\t\t   (၂)ဆ ပေးလျော်ရမည်။ စာအုပ်များငှားထားရာ ရက်လွန်\n\t\t   နေပါက တစ်ရက်လျင် ၂၀၀ ကျပ်နှုန်းဖြင့် ပေးဆောင်ရမည်။"+"\n";
        principle+="\t\t၉.  စာအုပ်ပြန်လည်မအပ်နှံပါက စာအုပ်ကြွေးကျန်\n\t\t   သတ်မှတ်ရ၍ စာမေးပွဲအောင်စာရင်း နှင့် အခြားမည်သည့် \n\t\t    ထောက်ခံစာ များကိုမှ လုံးဝလုံးဝ ထုတ်ပေးမည်မဟုတ်ပါ။"+"\n";
        principle+="\t\t၁၀. စာကြည့််တိုက်နှင့် ပတ်သက်၍ သိလိုခြင်း၊ အခက်အခဲရှိ\n\t\t     ခြင်းစသည့် ကိစ္စများကို စာကြည့်တိုက်မှူး(သို့)စာကြည့်\n\t\t    တိုက် တာဝန်ခံထံတွင် အကူအညီတောင်းခံနိုင်ပါသည်။"+"\n\n";

        txtprinciple=rootview.findViewById(R.id.txtpirnciple);
        txtpinciple1 = rootview.findViewById(R.id.txtpirnciple1);
        FontEmbedder.force(txtprinciple,principle1);
        FontEmbedder.force(txtpinciple1,principle);

        return rootview;
//        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
