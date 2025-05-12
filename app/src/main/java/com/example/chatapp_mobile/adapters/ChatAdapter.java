package com.example.chatapp_mobile.adapters;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatapp_mobile.databinding.ItemContainerReceivedMassageBinding;
import com.example.chatapp_mobile.databinding.ItemContainerSentMassageBinding;
import com.example.chatapp_mobile.models.ChatMessage;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<ChatMessage> chatMessages;

    private final Bitmap receiverProfileImage;
    private final String senderId;

    public static final int VIEW_TYPE_SENT = 1;
    public static final int VIEW_TYPE_RECEIVED = 2;

    public ChatAdapter(List<ChatMessage> chatMessages, Bitmap receiverProfileImage, String senderId) {
        this.chatMessages = chatMessages;
        this.receiverProfileImage = receiverProfileImage;
        this.senderId = senderId;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT) {
            return new SentMessageViewHolder(
                    ItemContainerSentMassageBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
            } else {
            return new receivedMessageViewHolder(
                    ItemContainerReceivedMassageBinding.inflate(
                            LayoutInflater.from(parent.getContext()),
                            parent,
                            false
                    )
            );
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_SENT){
            ((SentMessageViewHolder) holder).setData(chatMessages.get(position));
        }else{
            ((receivedMessageViewHolder) holder).setData(chatMessages.get(position), receiverProfileImage);
        }
    }

    @Override
    public int getItemCount() {
        return chatMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (chatMessages.get(position).senderId.equals(senderId)) {
            return VIEW_TYPE_SENT;
        } else {
            return VIEW_TYPE_RECEIVED;
        }
    }


    static class SentMessageViewHolder extends RecyclerView.ViewHolder {
        private final ItemContainerSentMassageBinding  binding;

        SentMessageViewHolder(ItemContainerSentMassageBinding itemContainerSentMassageBinding) {
            super(itemContainerSentMassageBinding.getRoot());
            binding = itemContainerSentMassageBinding;
        }
        void setData(ChatMessage chatMessage){
            binding.textMassage.setText(chatMessage.message);
            binding.textDateTime.setText(chatMessage.dateTime);
        }
    }

    static class receivedMessageViewHolder extends RecyclerView.ViewHolder {
        private final ItemContainerReceivedMassageBinding binding;
        receivedMessageViewHolder(ItemContainerReceivedMassageBinding itemContainerReceivedMassageBinding) {
            super(itemContainerReceivedMassageBinding.getRoot());
            binding = itemContainerReceivedMassageBinding;
        }
        void setData(ChatMessage chatMessage, Bitmap receiverProfileImage) {
            binding.textMassage.setText(chatMessage.message);
            binding.textDateTime.setText(chatMessage.dateTime);
            binding.imageProfile.setImageBitmap(receiverProfileImage);
        }
    }
}
