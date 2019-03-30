package com.illud.redalert.client.crimestoppermicroservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.illud.redalert.client.crimestoppermicroservice.ClientConfiguration;

@FeignClient(name="${crimestoppermicroservice.name:crimestoppermicroservice}", url="${crimestoppermicroservice.url:localhost:8084/crimestopper}", configuration = ClientConfiguration.class)
public interface CommentResourceApiClient extends CommentResourceApi {
}