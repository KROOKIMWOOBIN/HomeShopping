package com.member;

import lombok.*;

import javax.persistence.*;

@Entity
@Data			// Getter Setter
@Builder		// DTO -> Entity화
@AllArgsConstructor	// 모든 컬럼 생성자 생성
@NoArgsConstructor	// 기본 생성자
@Table(name = "member")
public class MemberDomain {

    @Id	// 내가 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)	// 자동 id 생성
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column
    private String username;

    @Column(nullable = false)
    private String password;
}

/*
1. nullable = false: 이 옵션은 해당 컬럼이 null 값이 될 수 없음을 나타냅니다.
                     즉, 데이터베이스에서 해당 컬럼에는 반드시 값이 존재해야 합니다.
                     이 옵션을 사용하면 데이터베이스에서 NOT NULL 제약 조건이 설정됩니다.

2. unique = true:    이 옵션은 해당 컬럼의 값이 고유해야 함을 나타냅니다.
                     즉, 데이터베이스에서 해당 컬럼의 값은 중복될 수 없습니다.
                     이 옵션을 사용하면 데이터베이스에서 UNIQUE 제약 조건이 설정됩니다.
 */