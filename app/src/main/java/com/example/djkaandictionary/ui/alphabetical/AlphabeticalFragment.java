package com.example.djkaandictionary.ui.alphabetical;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.djkaandictionary.Dictionary;
import com.example.djkaandictionary.MainActivity;
import com.example.djkaandictionary.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AlphabeticalFragment extends Fragment {

    private AlphabeticalViewModel alphabeticalViewModel;
    Spinner alphabeta ;
    Button searchAlphabetical;
    TextView resultQuery;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        alphabeticalViewModel =
                ViewModelProviders.of(this).get(AlphabeticalViewModel.class);
        View root = inflater.inflate(R.layout.fragment_alphabetical, container, false);

        alphabeta = root.findViewById(R.id.alphabeticalSpinner);
        searchAlphabetical = root.findViewById(R.id.alphabeticalButton);
        resultQuery = root.findViewById(R.id.alphabeticalTextView);

        List<String> alfavhta = new ArrayList<>();
        alfavhta.add("A");
        alfavhta.add("B");
        alfavhta.add("C");
        alfavhta.add("D");
        alfavhta.add("E");
        alfavhta.add("F");
        alfavhta.add("G");
        alfavhta.add("H");
        alfavhta.add("I");
        alfavhta.add("J");
        alfavhta.add("K");
        alfavhta.add("L");
        alfavhta.add("M");
        alfavhta.add("N");
        alfavhta.add("O");
        alfavhta.add("P");
        alfavhta.add("Q");
        alfavhta.add("R");
        alfavhta.add("S");
        alfavhta.add("T");
        alfavhta.add("U");
        alfavhta.add("V");
        alfavhta.add("W");
        alfavhta.add("X");
        alfavhta.add("Y");
        alfavhta.add("Z");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,alfavhta);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        alphabeta.setAdapter(adapter);

        searchAlphabetical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = alphabeta.getSelectedItem().toString();
                List<Dictionary> found = MainActivity.manager.myDao().searchWord(search);
                String result = "";
                for(Dictionary d: found){
                    String word = d.getWord();
                    String meaning = d.getMeaning();
                    result = result + "\nWord: "+ word + "\nMeaning: "+meaning+"\n";
                }
                resultQuery.setPadding(50,50,50,50);
                resultQuery.setTextColor(Color.parseColor("#000000"));
                Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                resultQuery.setTypeface(boldTypeface);
                resultQuery.setText(result);
            }
        });

        return root;
    }
}
