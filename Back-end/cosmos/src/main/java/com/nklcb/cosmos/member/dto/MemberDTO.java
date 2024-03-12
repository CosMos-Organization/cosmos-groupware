package com.nklcb.cosmos.member.dto;

import lombok.Getter;

public class MemberDTO {

    @Getter
    public static class MemberCreate {
        private String memberid;
        private String name;
        private String department;
        private String position;
        private String phone;
        private String email;

        public static MemberCreate of(String memberid, String name, String department, String position, String phone, String email) {
            MemberCreate memberCreate = new MemberCreate();
            memberCreate.memberid = memberid;
            memberCreate.name = name;
            memberCreate.department = department;
            memberCreate.position = position;
            memberCreate.phone = phone;
            memberCreate.email = email;
            return memberCreate;
        }



    }

}
