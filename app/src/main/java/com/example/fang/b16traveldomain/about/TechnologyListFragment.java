package com.example.fang.b16traveldomain.about;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fang.b16traveldomain.R;

public class TechnologyListFragment extends Fragment {

    private ListView list;

    public TechnologyListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tech,container,false);
        list = view.findViewById(R.id.tech_list_view);
        ArrayAdapter<CharSequence> aa = ArrayAdapter.createFromResource(getContext(), R.array.Tech_list, android.R.layout.simple_list_item_1);
        list.setAdapter(aa);
        getActivity().setTitle("Technology list");
        return view;
    }
}
