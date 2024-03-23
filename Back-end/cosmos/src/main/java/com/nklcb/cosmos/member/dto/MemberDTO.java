package com.nklcb.cosmos.member.dto;

import lombok.Getter;

public class MemberDTO {

    @Getter
    public static class MemberInfo {
        private String memberId;
        private String password;
        private String name;
        private String phone;
        private String department;
        private String position;


        public MemberInfo(String memberId, String password, String name, String phone, String department, String position) {
            this.memberId = memberId;
            this.password = password;
            this.name = name;
            this.phone = phone;
            this.department = department;
            this.position = position;
        }

    }
    

}
