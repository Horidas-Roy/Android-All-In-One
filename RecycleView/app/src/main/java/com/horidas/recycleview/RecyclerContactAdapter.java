package com.horidas.recycleview;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

     Context context;
     ArrayList<ContactModel> arrContacts;
     int lastPosition = -1;

     RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContacts){
          this.context = context;
          this.arrContacts = arrContacts;
     }

     @NonNull
     @Override
     public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View v = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
          ViewHolder viewHolder = new ViewHolder(v);
          return viewHolder;
     }

     @Override
     public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.imgContact.setImageResource(arrContacts.get(position).img);
            holder.contactName.setText(arrContacts.get(position).name);
            holder.contactNumber.setText(arrContacts.get(position).number);

            setAnimation(holder.itemView,position);

            holder.llrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.add_update);

                    EditText edName = dialog.findViewById(R.id.edName);
                    EditText edNumber = dialog.findViewById(R.id.edNumber);
                    Button addContactBtn = dialog.findViewById(R.id.addContactBtn);
                    TextView textTitle = dialog.findViewById(R.id.textTitle);

                    addContactBtn.setText("Update");
                    textTitle.setText("Update Contact");
                    edName.setText(arrContacts.get(position).name);
                    edNumber.setText(arrContacts.get(position).number);

                    addContactBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = "", number = "";

                            if(!edName.getText().toString().isEmpty()){
                                name = edName.getText().toString();
                            }else{
                                Toast.makeText(context, "Please enter your name!", Toast.LENGTH_SHORT).show();
                                edName.setError("Enter your name!!");
                            }

                            if (!edNumber.getText().toString().isEmpty()){
                                number = edNumber.getText().toString();
                            }else{
                                Toast.makeText(context, "Please enter your number!", Toast.LENGTH_SHORT).show();
                                edName.setError("Enter your number!!");
                            }

                            arrContacts.set(position,new ContactModel(arrContacts.get(position).img,name,number));
                            notifyItemChanged(position);

                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });
            holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(context)
                            .setTitle("Delete Contact")
                            .setMessage("Are you sure want to delete?")
                            .setIcon(R.drawable.delete)
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    arrContacts.remove(position);
                                    notifyItemRemoved(position);
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                    builder.show();


                    return true;
                }
            });
     }

     @Override
     public int getItemCount() {
          return arrContacts.size();
     }

     public static class ViewHolder extends RecyclerView.ViewHolder{
          TextView contactName,contactNumber;
          ImageView imgContact;
          LinearLayout llrow;

          public ViewHolder(@NonNull View itemView) {
               super(itemView);
               contactName = itemView.findViewById(R.id.contactName);
               contactNumber = itemView.findViewById(R.id.contactNumber);
               imgContact = itemView.findViewById(R.id.imgContact);
               llrow = itemView.findViewById(R.id.llrow);
          }
     }

     private void setAnimation(View viewToAnimate,int position){
         if(position>lastPosition) {
             Animation slideIn = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
             viewToAnimate.startAnimation(slideIn);
             lastPosition = position;
         }
     }

}
