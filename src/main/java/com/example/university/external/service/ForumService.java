package com.example.university.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.university.dto.MessageDTO;

@FeignClient(name="ONLINE-UNIVERSITY-FORUM")
public interface ForumService {
	@PostMapping("forum/send")
    public Object sendMessage(@RequestBody MessageDTO msg);
}
