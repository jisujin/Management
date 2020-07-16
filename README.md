고객이 PT 예약을 위해 트레이너를 선택해서 예약을 할 수 있는 시스템.

기능적 요구사항

고객이 PT 예약 신청을 한다.
PT 예약 신청을 하면, 트레이너가 해당 예약을 수락할지 거절할지 선택한다.(Req/Res 동기처리)
트레이너의 선택에 따라 관리 시스템에서 상태를 변경한다.
트레이너가 수락을 하면, 관리 시스템에서 예약 확정을 한다.
트레이너가 거절을 하면, 예약 시스템에서 예약 취소를 한다.
관리시스템에서 예약 현황을 수시로 확인할 수 있다.

비기능적 요구사항

트랜잭션

예약 신청과 트레이너의 선택이 동시 이루어 지도록 한다.

장애격리

성능
사용자는 예약 진행상태를 수시로 확인하여 모니터링 한다.(CQRS)

