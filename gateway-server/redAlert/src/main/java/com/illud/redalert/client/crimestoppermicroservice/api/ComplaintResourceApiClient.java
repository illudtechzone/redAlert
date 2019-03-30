package com.illud.redalert.client.crimestoppermicroservice.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.illud.redalert.client.crimestoppermicroservice.ClientConfigurationCS;

@FeignClient(name="${crimestoppermicroservice.name:crimestoppermicroservice}", url="${crimestoppermicroservice.url:localhost:8084/crimestopper}", configuration = ClientConfigurationCS.class)
public interface ComplaintResourceApiClient extends ComplaintResourceApi {
}