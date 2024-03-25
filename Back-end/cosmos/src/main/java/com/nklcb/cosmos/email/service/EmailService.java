package com.nklcb.cosmos.email.service;

import com.nklcb.cosmos.email.dto.EmailDto;
import com.nklcb.cosmos.email.entity.Email;
import com.nklcb.cosmos.email.repository.EmailRepository;
import com.nklcb.cosmos.member.entity.Member;
import com.nklcb.cosmos.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import nonapi.io.github.classgraph.json.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @packageName   : com.nklcb.cosmos.email.service
 * @fileName      : EmailService.java
 * @author        : cosmos
 * @date          : 2024.03.20
 * @description   : email crud
 * ===========================================================
 * DATE              AUTHOR       NOTE
 * -----------------------------------------------------------
 * 2023.10.23        김지홍         최초 생성
 */
@RequiredArgsConstructor
@Service
public class EmailService {


    private final EmailRepository emailRepository;
    private final MemberRepository memberRepository;


//    public void writeEmail(EmailDto emailDto) {
//        Optional<Member> member = memberRepository.findByMemberId(emailDto.getSenderAddress());
//        Email email = Email.builder()
//                .senderAddress(member.get())
//                .getterAddress(emailDto.getGetterAddress())
//                .content(emailDto.getContent())
//                .build();
//        emailRepository.save(email);
//    }

    public void writeEmail(EmailDto emailDto) {
        try{
            Email email = Email.builder()
                    .senderAddress(emailDto.getSenderAddress())
                    .getterAddress(emailDto.getGetterAddress())
                    .content(emailDto.getContent())
                    .build();
            emailRepository.save(email);

        }catch(DataAccessException e) {
                // 로그** -> merge 후에 수정
//                log.error("Email 저장 중 에러 발생", e);
//                throw new EmailSaveException("Email 저장 중 에러 발생", e);
            }
        }


    /**
     * 1. 개요: docAi 카테고리별 벡터DB정보
     * 2. 처리내용 :
     * 3. 입력 Data :
     * 4. 출력 Data :
     * @methodName  : readEmailList
     * @author      : cosmos
     * @date        : 2023.11.14
     * @description : 요청자의 이메일 불러오기
     * @param  emailDto
     * @return  List<Email>
     */
    public List<Email> readEmailList(EmailDto emailDto) {
        String senderAddress = emailDto.getSenderAddress();
        List<Email> emailList = emailRepository.findAllBySenderAddress(senderAddress);
        return emailList;
    }
}