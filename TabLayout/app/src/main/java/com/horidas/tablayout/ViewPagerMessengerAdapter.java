package com.horidas.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerMessengerAdapter extends FragmentPagerAdapter {
    public ViewPagerMessengerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
         if(position == 0){
             return new ChatsFragment();
         } else if (position == 1) {
             return new StatusFragment();
         }else {
             return new CallsFragment();
         }

         /**switch (position){
             case 1:
                 return new StatusFragment();
             case 2:
                 return new CallsFragment();
             default:
                 return new ChatsFragment();
         }*/
    }

    @Override
    public int getCount() {
        return 3;  //No of Tab item
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
         if(position == 0){
             return "Chats";
         } else if (position == 1) {
             return "Status";
         }else{
             return "Calls";
         }
    }
}
