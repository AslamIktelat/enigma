package com.ai.enigma.agent;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActionResponse {
    List<String> actions;
    String reason;
}
