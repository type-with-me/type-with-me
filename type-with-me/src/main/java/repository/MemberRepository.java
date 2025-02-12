package repository;

import aggregate.Member;
import aggregate.UserType;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberRepository {
    // file 에서 불러온 Member 정보를 담는 컬렉션
    private final ArrayList<Member> members = new ArrayList<>();
    // file 경로 지정
    private final File file=
            new File("/Users/mk/Desktop/type-with-me/type-with-me/src/main/java/db/memberDB.dat");

    /* 설명: 생성자*/
    public MemberRepository() {
        /* 설명: 파일이 존재하지 않는 경우
        *   1. 더미데이터 1개 생성
        *   2. 파일에 더미데이터 출력*/
        if(!file.exists()){
            ArrayList<Member> defaultMembers = new ArrayList<>();
            defaultMembers.add(new Member("user0001","pass0001", UserType.ELEMENTARY));
            saveMembersToFile(defaultMembers);
        }
        loadMembersFromFile();
    }

    private void loadMembersFromFile() {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream=new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(file)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* 설명: Member 컬렉션을 매개변수로 받아 파일에 출력하는 함수*/
    private void saveMembersToFile(ArrayList<Member> members) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream=new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(file)));
            for(Member member:members){
                objectOutputStream.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
