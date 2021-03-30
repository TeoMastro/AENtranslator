package com.example.djkaandictionary.ui.home;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.djkaandictionary.Dictionary;
import com.example.djkaandictionary.MainActivity;
import com.example.djkaandictionary.R;

import org.w3c.dom.Text;

import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    EditText searchText;
    TableLayout tableLayout;
    TextView word;
    TextView meaning;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);

        searchText = root.findViewById(R.id.searchEditText);
        tableLayout = root.findViewById(R.id.searchTableLayout);
        word = root.findViewById(R.id.wordTextView);
        meaning = root.findViewById(R.id.meaningTextView);

        word.setVisibility(word.INVISIBLE);
        meaning.setVisibility(meaning.INVISIBLE);

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String search = searchText.getText().toString();
                List<Dictionary> found = MainActivity.manager.myDao().searchWord(search);
                String result = "";

                tableLayout.removeAllViews();
                tableLayout.setColumnShrinkable(0,true);
                tableLayout.setColumnShrinkable(1,true);

                word.setVisibility(word.VISIBLE);
                meaning.setVisibility(meaning.VISIBLE);

                for(Dictionary d: found){
                    String word = d.getWord();
                    String meaning = d.getMeaning();

                    TableRow tempRow=new TableRow(root.getContext());
                    TextView txtWord=new TextView(root.getContext());
                    TextView txtMeaning=new TextView(root.getContext());

                    tempRow.setBackground(ContextCompat.getDrawable(root.getContext(),R.drawable.border));

                    txtWord.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                    txtMeaning.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                    txtWord.setPadding(10,10,10,10);
                    txtMeaning.setPadding(10,10,10,10);

                    txtWord.setText(word);
                    txtMeaning.setText(meaning);

                    txtWord.setTextColor(Color.parseColor("#000000"));
                    txtMeaning.setTextColor(Color.parseColor("#000000"));

                    Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);

                    txtWord.setTypeface(boldTypeface);
                    txtMeaning.setTypeface(boldTypeface);

                    tempRow.addView(txtWord);
                    tempRow.addView(txtMeaning);
                    tableLayout.addView(tempRow);
                }
                if(searchText.getText().toString().equals("")){
                    tableLayout.removeAllViews();
                    word.setVisibility(word.INVISIBLE);
                    meaning.setVisibility(meaning.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return root;
    }

}
