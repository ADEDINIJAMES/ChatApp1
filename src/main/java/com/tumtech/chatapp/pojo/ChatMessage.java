package com.tumtech.chatapp.pojo;

import com.tumtech.chatapp.enums.MessageType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType messageType;
}
