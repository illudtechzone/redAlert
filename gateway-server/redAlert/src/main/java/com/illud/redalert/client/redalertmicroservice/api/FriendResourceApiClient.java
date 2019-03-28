package com.illud.redalert.client.redalertmicroservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.illud.redalert.client.redalertmicroservice.ClientConfiguration;

@FeignClient(name="${redalertmicroservice.name:redalertmicroservice}", url="${redalertmicroservice.url:localhost:8081/redAlert}", configuration = ClientConfiguration.class)
public interface FriendResourceApiClient extends FriendResourceApi {
}