package com.azhar.biodatanabi.ui;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azhar.biodatanabi.R;
import com.azhar.biodatanabi.model.Nabi;
import com.baoyachi.stepview.VerticalStepView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Azhar Rivaldi on 23/03/2018.
 */

public class GarisKeturunanNabi extends BottomSheetDialogFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.step_view)
    VerticalStepView verticalStepView;

    Nabi nabi;

    public static GarisKeturunanNabi newInstance(Nabi nabi) {
        Bundle args = new Bundle();
        args.putParcelable("NABI", nabi);
        GarisKeturunanNabi fragment = new GarisKeturunanNabi();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            nabi = getArguments().getParcelable("NABI");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.silsilah_dialog, container, false);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.bind(this, view);

        toolbar.setTitle("Garis Keturunan");
        toolbar.setSubtitle("Garis Keturunan Nabi " + nabi.getNama());

        if (getContext() != null) {
            verticalStepView.setStepViewTexts(nabi.getGarisKeturunan());
            verticalStepView.setTextSize(16);
            verticalStepView.reverseDraw(false);
            verticalStepView.setStepsViewIndicatorCompletedLineColor(Color.parseColor("#918F8D"));
            verticalStepView.setStepsViewIndicatorUnCompletedLineColor(Color.parseColor("#918F8D"));
            verticalStepView.setStepsViewIndicatorCompleteIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_complete));
            verticalStepView.setStepsViewIndicatorDefaultIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_complete));
            verticalStepView.setStepsViewIndicatorAttentionIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_complete));
            verticalStepView.setStepViewComplectedTextColor(Color.parseColor("#0097A7"));
            verticalStepView.setStepViewUnComplectedTextColor(Color.parseColor("#0097A7"));
            verticalStepView.setStepsViewIndicatorComplectingPosition(1);
        }
    }
}
