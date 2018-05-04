package medifact.upin.medifact;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI_Calculator extends Fragment
{
    Activity BMIActivity;
    View parentHolder;
    Button result_btn;
    EditText height;
    EditText weight;
    TextView result;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        BMIActivity = getActivity();
        parentHolder = inflater.inflate(R.layout.bmi_calc,container,false);
        result_btn = (Button)parentHolder.findViewById(R.id.result_btn);
        height = (EditText)parentHolder.findViewById(R.id.height);
        weight = (EditText)parentHolder.findViewById(R.id.weight);
        result = (TextView) parentHolder.findViewById(R.id.result);

        result_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();
                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null && !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);

                    float bmi = weightValue / (heightValue * heightValue);
                    String bmiLabel = "";

                    if (Float.compare(bmi, 15f) <= 0) {
                        bmiLabel = getString(R.string.very_severely_underweight);
                    } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
                        bmiLabel = getString(R.string.severely_underweight);
                    } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
                        bmiLabel = getString(R.string.underweight);
                    } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
                        bmiLabel = getString(R.string.normal);
                    } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
                        bmiLabel = getString(R.string.overweight);
                    } else if (Float.compare(bmi, 30f) > 0 && Float.compare(bmi, 35f) <= 0) {

                        bmiLabel = getString(R.string.obese_class_i);
                    } else if (Float.compare(bmi, 35f) > 0 && Float.compare(bmi, 40f) <= 0) {
                        bmiLabel = getString(R.string.obese_class_ii);
                    } else {
                        bmiLabel = getString(R.string.obese_class_iii);
                    }

                    bmiLabel = "BMI Value : " + bmi + "\n\n Class : " + bmiLabel;
                    result.setText(bmiLabel);
                }
            }
        });
        return parentHolder;
        }



    }




