package day65task.service;

import day65task.model.dto.OrderDto;
import day65task.model.entity.MemberEntity;
import day65task.model.entity.OrderEntity;
import day65task.model.entity.ProductEntity;
import day65task.model.repository.MemberRepository;
import day65task.model.repository.OrderRepository;
import day65task.model.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<OrderDto> mypage(int mno) {
        // 1. mno의 회원 엔티티를 찾는다.
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent()) {
            MemberEntity memberEntity = optionalMember.get(); // optimalMember에서 객체/엔티티를 꺼낸다.
            // 2. 찾은 엔티티에서 양방향 설정 주문 조회
            List<OrderEntity> orderEntityList = memberEntity.getOrderEntityList();

            // 3. .stream().map(타입 :: 함수명).collect(Collectors.반환타입);
            List<OrderDto> list = orderEntityList.stream()
                    .map(OrderEntity :: toDto)
                    .collect(Collectors.toList()); // 반환타입
            // list 반환
            return list;
        }
        return null;
    }

    @Transactional
    public boolean order(OrderDto orderDto) {
        // 1. 임의의 로그인 번호 및 구매하려는 제품의 제품 번호 설정
        int mno = 1; int pno = 1;
        // 1-2. 현재 로그인 여부를 확인하고 비로그인 상태일 시 취소 처리
        Optional<MemberEntity> optionalMember = memberRepository.findById(mno);
        if (optionalMember.isPresent() == false) {
            return false;
        } // if ed
        // 1-3. 마찬가지로 구매하려는 제품 번호를 확인하고 제품이 존재하지 않을 시 취소 처리
        Optional<ProductEntity> optionalMember2 = productRepository.findById(pno);
        if (optionalMember2.isPresent() == false) {
            return false;
        } // if ed

        // get 메서드로 optimal 객체 내 엔티티를 꺼낸다.
        MemberEntity memberEntity = optionalMember.get();
        ProductEntity productEntity = optionalMember2.get();

        // 2. 주문 엔티티를 생성한다. 이때 DTO를 엔티티로 전환한다.
        OrderEntity orderEntity = orderDto.toEntity();

        // 3. 주문 엔티티에 회원엔티티를 넣는다.
        orderEntity.setMemberEntity(memberEntity);
        orderEntity.setProductEntity(productEntity);

        // 4. 주문 엔티티를 저장한다.
        OrderEntity saveEntity = orderRepository.save(orderEntity);

        // 5. 엔티티 저장에 성공하면 성공한 엔티티 영속성 연결/매핑
        if(saveEntity.getOno() > 0) {return true;}
        return false;
    } // f ed

} // c ed
