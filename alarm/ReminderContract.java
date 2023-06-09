package com.vishwajeeth.medicinetime.alarm;

import com.vishwajeeth.medicinetime.BasePresenter;
import com.vishwajeeth.medicinetime.BaseView;
import com.vishwajeeth.medicinetime.data.source.History;
import com.vishwajeeth.medicinetime.data.source.MedicineAlarm;

/**
 * Created by iu student on 4/07/23.
 */

public interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
