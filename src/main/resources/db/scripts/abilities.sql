INSERT INTO sc_abilities(name, category, description, win_count, loss_count)
VALUES ('강령술', '모든 종족 공용', '아무 플레이어의 유닛이 죽으면 15% 확률로 그 자리에서 내 유닛으로 부활합니다.', 0, 0),
       ('공격타입의 지배자', '모든 종족 공용', '비콘에 유닛을 올려놓을 때마다, 게임 내 모든 공격타입을 폭발형→진동형→일반형→폭발형 순서로 전환할 수 있습니다. 첫 발동은 폭발형입니다.', 0, 0),
       ('공생충', '모든 종족 공용', '유닛이 죽은 자리에서 해당 유닛의 인구수x2 만큼 브루들링이 생깁니다. 건물이 파괴되면 12 마리가 생깁니다.', 0, 0),
       ('광산 대기업', '모든 종족 공용',
        '가스 채취 건물이 2초당 1미네랄을 생산합니다. 가스 건물을 추가할 때마다 생산량이 두 배씩 늘어납니다. 예) 가스건물 1→2→3→4→... 개 : 2초당 1→2→4→8→... 미네랄.', 0,
        0),
       ('궤도 폭격', '모든 종족 공용',
        '5분 후, 마인을 매우 멀리 보낼 수 있는 영웅 벌처가 소환됩니다. 마인은 개당 15 미네랄, 10초 동안 무적 상태로 이동. 벌처는 공격 불가, 죽으면 1분 후 부활.', 0, 0),
       ('날림 공사', '모든 종족 공용', '1분30초 후 부터, 건물이 3배속으로 지어지지만, 체력이 40% 인 채로 완성됩니다. 건물에 1초당 1체력 재생이 추가됩니다.', 0, 0),
       ('노출증', '모든 종족 공용', '본진에 적 유닛이 1개 있으면 자원을 초당 6/3 씩 얻습니다. 적 유닛이 2개 이상 있거나 건물이 있으면, 18/9 씩 얻습니다.', 0, 0),
       ('녹즙 여왕', '모든 종족 공용', '비콘에 일꾼을 가져가면 미네랄, 가스 각 50을 소모하여 에너지가 75로 고정된 영웅 퀸을 소환합니다. 영웅 퀸은 최대 1기만 보유 가능합니다.', 0, 0),
       ('''느려.''', '모든 종족 공용',
        '채팅에 느려. (마침표 포함)를 입력하면 아래 효과가 발동됩니다. 게임 내 모든 공격 투사체가 10배 느려지고, 대상을 추적하지 않습니다. 대신 좁은 범위의 스플래시가 생깁니다.', 0, 0),
       ('뒷산에서 버섯캐기', '모든 종족 공용', '제3멀티(삼룡이)에 버섯이 생깁니다. 버섯이 파괴되면 자원을 얻고 다음 버섯이 나옵니다. 버섯과 보상은 점점 좋아집니다.', 0, 0),
       ('루팅', '모든 종족 공용', '적 유닛이 죽으면 그 유닛의 비용의 40%를 받습니다.', 0, 0),
       ('미네랄 도둑', '모든 종족 공용', '일꾼이 적 본진의 미네랄을 캐면 8이 아닌 500씩 캐고 캔 미네랄을 2분 동안 못 캐게 합니다.', 0, 0),
       ('민병대', '모든 종족 공용',
        '비콘에서 같은 비용만큼 일꾼유닛 ↔ 기본유닛(마린,질럿,저글링) 교환이 됩니다. 기본유닛이 죽으면, 절반 비용만큼 일꾼으로 부활합니다. 단, 3분 30초 전에는 기본유닛이 적 본진에 못 들어갑니다.',
        0, 0),
       ('방플', '모든 종족 공용', '나와 팀원은 모든 플레이어의 능력을 알게 되고, 맵핵이 켜집니다.', 0, 0),
       ('불 좀 꺼줄래?', '모든 종족 공용',
        '비콘에 유닛을 넣으면, 7초 후, 23초 동안 적 플레이어의 시야가 어두워집니다. (참고: 적을 공격한 불투명 유닛은 잠시 적에게 보입니다) (쿨타임 3분)', 0, 0),
       ('비트코인', '모든 종족 공용', '30초마다 미네랄과 가스의 양이 무작위로 30% ~ 230%가 됩니다.', 0, 0),
       ('비폭력주의', '모든 종족 공용', '일꾼이 공격한 대상과 일꾼을 공격한 대상 위치에 5초 지속 디스럽션 웹이 설치됩니다.', 0, 0),
       ('삥뜯기', '모든 종족 공용', '팀원이 내 본진에 유닛을 넣으면 그 유닛이 사라지고 유닛 비용의 3배만큼의 자원을 내가 받습니다.', 0, 0),
       ('사전 지식', '모든 종족 공용', '모든 공/방 1업이 완료됩니다.', 0, 0),
       ('상대는 가난하다구', '모든 종족 공용', '적 일꾼이 죽으면, 자원 50/50을 얻습니다. 적 오버로드, 서플라이, 파일런이 파괴되면, 200/200을 얻습니다.', 0, 0),
       ('수송부대', '모든 종족 공용', '1분마다 화물(스캐럽 불가 리버)이 생성됩니다. 화물을 팀원 본진에 전달하면 나와 팀원이 자원 200/200을 얻습니다.', 0, 0),
       ('스트리머', '모든 종족 공용',
        '비콘에 유닛이 있는 동안, 모든 적 플레이어에게 시야를 공유합니다. 시야를 공유받은 상대는 평균적으로 1분마다 최대 150미네랄, 50가스 까지 강제로 후원합니다.[A]', 0, 0),
       ('쌍둥이', '모든 종족 공용', '건물과 라바가 유닛을 2기씩 40% 실드와 체력으로 생산합니다. (일꾼, 오버로드, 저글링, 스커지 제외)', 0, 0),
       ('아 맞다 서플라이/오버로드/파일론', '모든 종족 공용', '인구수가 200이 됩니다. 서플라이/오버로드/파일론이 파괴되면 100 미네랄을 회수합니다.', 0, 0),
       ('아몬께서 별빛으로 속삭이셨다', '모든 종족 공용', '게임 시작 18분 후, 적 플레이어는 본인 포함 모두와 적대 관계가 되고 시야가 공유됩니다.', 0, 0),
       ('앞마당 스타트', '모든 종족 공용', '30초 후, 적 플레이어의 본진 건물이 앞마당으로 이동하고 이사 지원금 50 미네랄을 지급합니다.', 0, 0),
       ('외계인 고문', '모든 종족 공용', '연구와 업그레이드가 즉시 완료되지만, 완료될 때마다 일꾼 1명이 죽습니다.', 0, 0),
       ('월리를 찾아라', '모든 종족 공용',
        '중립 고스트와 영웅들이 맵을 돌아다니며, 이 중 월리(감염된 듀란)가 죽으면 나머지가 내 소유가 됩니다. 고스트는 유닛에 막히지 않습니다. 4분 후부터 월리의 위치를 대략 알려줍니다.', 0, 0),
       ('유레카', '모든 종족 공용', '게임 시작 12분 후 공/방 4업이 완료됩니다.', 0, 0),
       ('이 건물은 이제 제 겁니다', '모든 종족 공용', '다른 플레이어의 건물이 파괴되면, 내 것이 됩니다. (나간 플레이어도 적용. 가스 건물, 애드온 제외)', 0, 0),
       ('인성타니스', '모든 종족 공용', '2분 후부터, 유닛이 죽으면 (해당 유닛의 인구수) × 20%의 확률로 본진에서 드라군으로 부활합니다. 첫 부활 이후 드라군 사업 연구가 제공됩니다.', 0,
        0),
       ('일꾼 환전소', '모든 종족 공용', '1분 후부터, 비콘에 일꾼 2기를 넣으면 200미네랄과 100가스로 바뀝니다.', 0, 0),
       ('자원은 균형있게', '모든 종족 공용', '2분마다 미네랄과 가스의 양이 더 많은 쪽으로 맞춰집니다.', 0, 0),
       ('재생력', '모든 종족 공용', '유닛과 건물에 1 초당 1 체력, 실드, 에너지 재생이 추가됩니다. 2 분마다 재생량이 1 씩 늘어납니다.', 0, 0),
       ('전역까지 얼마나 남았지...', '모든 종족 공용', '적 유닛과 건물이 블라인드 상태입니다. (디텍터 제외) 2킬을 올린 유닛/건물은 풀립니다.[A]', 0, 0),
       ('최고급 정제소', '모든 종족 공용', '가스 건물에서 버튼을 눌러 250 미네랄과 가스 건물 둘 다 소모하고 5000가스를 얻을 수 있습니다. 이후 간헐천은 사라집니다.', 0, 0),
       ('최후의 저항(삭제)', '모든 종족 공용', '유닛이 죽으면, 한 번 10% 체력으로 부활하고 1초 동안 디펜시브 매트릭스로 보호됩니다.', 0, 0),
       ('치유의 노래', '모든 종족 공용', '매 1분마다, 나와 팀원의 모든 체력과 실드가 5초 동안 100%로 고정됩니다.', 0, 0),
       ('피버 타임', '모든 종족 공용', '2분마다 모든 적 유닛, 건물에 20초간 지속되는 애시드 스포어를 뿌립니다. 발동될 때마다 애시드 스포어가 1단계씩 강해집니다.', 0, 0),
       ('환영술사', '모든 종족 공용', '유닛을 생산하면 그 유닛의 환상(10분 지속)을 추가로 하나 받습니다.', 0, 0),
       ('다문화주의', '모든 종족 공용',
        '커맨드(못띄움), 해처리, 넥서스, 오버로드, 2 드론, SCV, 프로브로 시작합니다. 테란, 저그, 플토 건물을 각각 7종류 이상씩 보유 시 5초마다 무작위 일반 유닛을 얻습니다.[R]', 0,
        0),
       ('꿀벌행동', '모든 종족 공용',
        '일꾼이 공중 유닛이고 공격할 수 없습니다. 일꾼이 자원을 건물에 넣으면 8만큼이 아니라 캔 위치와 넣는 건물 사이 거리만큼의 자원이 오릅니다. (획득량은 일꾼 킬수에 표시)[R]', 0, 0),
       ('랜능크 하제는 세계 최고의 유즈맵이다', '모든 종족 공용',
        '채팅에 이 능력의 이름(띄어쓰기 불필요)을 입력하면 자원을 받습니다. (시작 60미네랄 / 30가스, 매 회 획득량 10미네랄 / 5가스씩 증가) 시작 쿨 1분, 재사용 쿨 30초.', 0, 0),
       ('소멸', '모든 종족 공용', '체력+실드가 1 이상, 최대값의 15% 이하인 적 유닛(일꾼 제외)은 환상이 됩니다. (환상이 된 유닛은 죽을 때 죽음 관련 능력을 발동시키지 않습니다.)', 0,
        0),
       ('포탈', '모든 종족 공용', '아무 플레이어의 비콘에 내 유닛이 들어가면, 그 플레이어의 팀원 본진으로 순간이동합니다.', 0, 0),
       ('우리는 하나다', '모든 종족 공용',
        '2분 후부터, 나와 팀원은 자원과 인구를 공유합니다.내가 Delete 키를 누르면 우리 팀 유닛이 내 비콘 → 팀원 본진, 팀원 비콘 → 내 본진으로 순간이동합니다.', 0, 0),
       ('그린벨트', '모든 종족 공용',
        '매 초 자원을 얻습니다. (시작 2/1, 1분마다 2/1씩 획득량 추가) 단, 본진에 있는 건물(남의 건물, 미완성 건물 포함) 하나마다 획득량이 4/2씩 줄어듭니다.', 0, 0),
       ('마피아 게임', '모든 종족 공용',
        'Delete키를 누르면 무작위 적 유닛 가격의 2.5배를 내고 내 스파이로 만듭니다.(일꾼, 수송선 제외) 채팅에 밤이되었습니다 를 입력하면 5초 후 스파이들이 모두 내 소유가 됩니다. 쿨타임 1분.',
        0, 0),
       ('활동 비용', '모든 종족 공용', '2분 후부터 초당 16미네랄과 8가스를 얻습니다. 하지만 숫자 키를 누르거나 좌클릭 또는 우클릭을 할 때마다 8미네랄 4가스가 잃습니다.', 0, 0),
       ('타소니스 침공(삭제)', '모든 종족 공용',
        '본진에 사이오닉 방출기를 받습니다. 게임 시작 5분 후부터, 내 비콘에 유닛을 배치해놓는 동안, 야생 저그가 방출기의 위치로 계속 공격해옵니다. 저그는 시간이 갈 수록 많아집니다.', 0, 0),
       ('폭탄 공장', '모든 종족 공용',
        '감염된 커맨드를 가지고 시작합니다.(파괴시 1분 후 재생성) 감염된 커맨드가 2배 빠르고 인페스티드 테란 인구수가 0이며 4분 후부터 생산 가능하고 8분 후부터 즉시 생산됩니다.', 0, 0),
       ('당일 배송', '테란, 프로토스 공용', '유닛이 즉시 생산됩니다. 하지만 50%의 확률로 40초 동안 스테이시스에 갇힙니다.', 0, 0),
       ('알박기', '테란, 프로토스 공용',
        '적 1명의 본진에 띄우지 않은 내 건물이 있으면 초당 미네랄 6, 가스 3을 받습니다. 적 2명의 본진에 띄우지 않은 내 건물이 있으면 대신 초당 미네랄 18, 가스 9를 받습니다.', 0, 0),
       ('간이 공장', '테란 전용',
        '애드온을 지으면, 유닛으로 바뀝니다.(마나사용 불가) 콤샛 → 베슬, 머신샵 → 탱크, 컨트롤타워 → 레이스, 코버트옵스 → 4고스트, 퍼실리티+피직스랩 → 배틀크루저', 0, 0),
       ('감염된 마인', '테란 전용', '벌처가 스파이더 마인 대신 동맹 컴퓨터 소유의 인페스티드 테란을 심습니다. (체력 30)', 0, 0),
       ('거치형 레이저총', '테란 전용', '벙커 안의 마린이 레이저를 쏩니다.(대미지 25(+2), 사거리 9) 벙커 건설 비용이 100미네랄 100가스가 됩니다.', 0, 0),
       ('공군 호출', '테란 전용', '스캔을 뿌리면 그 위치에 동맹 컴퓨터 레이스 4기를 소환합니다. 레이스들은 8초 후 사라집니다. (이 레이스들은 사망 판정을 일으키지 않습니다.)', 0, 0),
       ('드라군은 이레데잇에 죽어', '테란 전용',
        '연구가 끝난 퍼실리티가 주어지며, 베슬의 마나가 3배 빨리 찹니다. 베슬 외 모든 유닛, 건물에 생체 판정이 생겨 이레디에이트의 대상이 되고 피해를 입습니다. 단, 건물은 직접 피해만 받습니다.',
        0, 0),
       ('똑똑한 마인', '테란 전용', '벌처의 마인 매설이 벌처 사거리 8의 범위에서 가능해집니다. 마인 연구 이후, 2분마다 벌처의 마인이 모두 충전됩니다.', 0, 0),
       ('라면 먹고 갈래?', '테란 전용', '벙커 안에 마린과 메딕 단 둘만 있으면, 20초마다 무작위 배럭스 유닛이 생깁니다.', 0, 0),
       ('목격자가 없으면 암살', '테란 전용', '고스트의 시작 체력이 2배, 공격 속도가 약 11배가 됩니다.', 0, 0),
       ('미사일 만능주의', '테란 전용', '골리앗, 레이스, 미사일 터렛이 지상으로도 미사일 공격을 합니다.', 0, 0),
       ('바이킹', '테란 전용', '채팅에 이륙! 을 입력하면, 모든 골리앗이 발키리로 변합니다. 착륙! 을 입력하면, 모든 발키리가 골리앗으로 변합니다.', 0, 0),
       ('아주 무지막지한 놈들이지', '테란 전용',
        '배럭스에서 불곰을 생산할 수 있습니다. (아카데미 필요) 불곰: 체력 125 (대형), 지상 공격력 20 (폭발형), 스팀팩 사용 가능. 공격 대상에 0.7초 지속 인스네어 부여.', 0, 0),
       ('애드온 합체로봇', '테란 전용',
        '애드온 6종류를 모두 보유하면 6개 모두 파괴하고 영웅 배틀크루저(체력 2000, 공 60(+10), 방 4, 에너지 무한, 이동 중 공격 가능한 레이저포 보유, 마컨 면역)를 얻습니다.', 0,
        0),
       ('이동식 터렛', '테란 전용', '아머리가 있으면 터렛에서 골리앗으로, 골리앗에서 터렛으로 변신할 수 있습니다.', 0, 0),
       ('이북리더', '테란 전용',
        '핵무장이 되어있는 뉴클리어 사일로를 가지고 시작합니다. 추가 핵무장 시, 인구수가 들지 않고 즉시 완료됩니다. 코버트 옵스 테크 요구사항이 충족되고, 모든 고스트 연구가 제공됩니다.', 0, 0),
       ('전격전', '테란 전용', '배럭스 유닛에 이동속도 업그레이드가 적용됩니다. 머신샵을 지으면 팩토리 유닛에 이동속도 업그레이드가 적용되고, 시즈모드가 3배 빨라집니다.', 0, 0),
       ('젊은 피를 팔아', '테란 전용', '비콘에 배럭스 유닛을 넣으면, 무작위 적 본진에 팔아넘깁니다. 판매시 유닛 비용의 200% 를 받고, 받은 플레이어는 유닛 비용의 80% 를 지불합니다.', 0,
        0),
       ('지게로봇', '테란 전용',
        '스캔을 뿌린 위치에 강화된 SCV를 소환합니다. 강화된 SCV는 체력, 이동 속도가 높고, 미네랄과 가스를 25씩 캡니다. 마나가 0인 컴샛 스테이션을 가지고 시작합니다.', 0, 0),
       ('진정한 불꽃 러시', '테란 전용', '파이어뱃이 항상 스팀팩 상태고, 공격타입이 일반형입니다.', 0, 0),
       ('초패스트 앞마당', '테란 전용', '앞마당에 커맨드 센터가 착지해 있으면, 초당 5미네랄과 2가스를 얻습니다.', 0, 0),
       ('총검술', '테란 전용', '마린의 체력과 공격력이 2배고, 방어력이 1입니다. 대신, 사거리가 1입니다. 사거리 업그레이드시 2입니다.', 0, 0),
       ('태양권', '테란 전용',
        '메딕의 옵티컬 플레어가 피아구분 없는 100의 일반형 스플래시 대미지를 줍니다. 스플래시 범위는 리버 스캐럽과 같습니다. 건물 및 맨땅에도 쓸 수 있습니다. 모든 메딕 연구가 완료됩니다.', 0,
        0),
       ('포격 모드', '테란 전용',
        '시즈 모드 탱크가 주변 적을 자동으로 공격하지 않습니다. 대신 시즈 모드 중 공격(A)키로 목표 위치를 설정하면 1초 후부터 그곳을 매우 빠르게 포격합니다. 시즈모드 연구가 완료됩니다.', 0,
        0),
       ('행성 요새', '테란 전용',
        '커맨드 센터가 착륙한 상태면 주변 적을 자동으로 공격합니다. (공격력 40(+5), 일반형 지상 공중 단일 공격, 사거리 약 7, 퉁퉁포 공격 속도, 테란 차량 공격력 업그레이드 적용)', 0,
        0),
       ('ICBM', '테란 전용',
        '스캔을 뿌리면, 100미네랄 100가스를 소모하여 그 위치에 핵미사일을 발사합니다. 대신 발사 지점에 파괴 가능한 표적이 생기고, 떨어지기 전에 표적이 파괴되면 핵 공격이 취소됩니다.', 0, 0),
       ('낙하기', '테란 전용', '아카데미를 지은 이후로, 배럭스와 스타포트에서 유닛이 생산되면 랠리포인트 위치에 생깁니다.', 0, 0),
       ('화염기갑병', '테란 전용',
        '배럭스에서 파이어뱃 대신 화염기갑병을 뽑을 수 있습니다. (아카데미 필요)화염기갑병: 미네랄 75, 공 30+4 방 1 체 135, 중형, 공속 벌처급, 차량 업글. 팩토리가 있으면 벌처 ↔ 화기갑 변신 가능.',
        0, 0),
       ('넌 강해졌다', '테란 전용', '사이언스 베슬의 디펜시브 매트릭스가 강화됩니다. (보호막 수치 250 → 2000, 디펜시브 매트릭스 중 체력 회복과 스팀팩 효과)', 0, 0),
       ('스쿼트', '테란 전용', '커맨드를 제외한 건물을 올렸다 내릴때마다 그 건물의 건설비용의 30%를 돌려 받습니다.', 0, 0),
       ('가챠 중독', '저그 전용', '스커지를 비콘에 넣으면 50% 확률로 무작위  공중 유닛으로 바뀝니다. 50% 확률로 폭사합니다. 10회마다 스커지 10마리 또는 업그레이드 보너스가 있습니다.',
        0, 0),
       ('가필승', '저그 전용', '내 가디언이 속업되고 체력, 사거리, 공격력이 2배가 됩니다.', 0, 0),
       ('감염된 브루들링', '저그 전용', '브루들링이 인페스티드 테란으로 바뀝니다.(체력 30, 수명 5초) 퀸의 모든 연구가 완료되며, 마나가 2배 빨리 찹니다.', 0, 0),
       ('곱등이 번식하기', '저그 전용',
        '러커가 2 히드라로 변하면서 75가스를 반환합니다. 가디언, 디바우러가 2 뮤탈리스크로 변합니다. 러커, 가디언, 디바우러 변태가 5초 걸리고, 테크 없이 가능합니다.', 0, 0),
       ('낙하 주머니', '저그 전용',
        '해처리에서 해처리를, 크립 콜로니에서 크립 콜로니를, 맵의 아무 빈 공간에, 시야 없이도 지을 수 있습니다. (해처리: 225 미네랄, 크립 콜로니: 125 미네랄)', 0, 0),
       ('똑똑한 러커', '저그 전용', '러커가 투명해지고 버로우 없이 공격할 수 있습니다.', 0, 0),
       ('랩터 변종', '저그 전용', '하이브가 있으면, 저글링이 지형과 충돌을 무시하며 이동하고, 적에게 돌진 공격을 합니다. 기존 저글링 발업은 불가능합니다.', 0, 0),
       ('메카 대군주', '저그 전용',
        '레어가 있으면 오버로드가 메카 대군주로 교체됩니다. 메카 대군주: 배틀급 이속(이속업 가능), 수송 불가, 대공 8+1, 대지 4+1. 하이브 완성 시 대공 16+2, 대지 8+1.', 0, 0),
       ('무한 라바', '저그 전용', '레어와 하이브의 라바가 항상 3마리로 유지됩니다.', 0, 0),
       ('방어타워 증식', '저그 전용', '성큰 콜로니 및 스포어 콜로니가 1분마다 같은 위치에 2배로 겹쳐 생성됩니다. (같은 위치에 최대 제한 16개)', 0, 0),
       ('실크업', '저그 전용', '지상 유닛이 체력의 150% 만큼의 실드를 가집니다. 그러나 영구 지속 인스네어에 걸립니다.(라바, 에그, 드론 제외)', 0, 0),
       ('암흑 대군주', '저그 전용', '오버로드가 투명하고, 탑승한 유닛을 빠르게 내립니다. 속도, 시야 업그레이드가 완료되며 레어 완성 시 수송 업그레이드가 제공됩니다.', 0, 0),
       ('양념의 제왕', '저그 전용', '퀸이 인스네어를 시전하면 해당 위치에 플레이그도 뿌려지고 근처 유닛이 애시드 스포어 5단계에 걸립니다. 인스네어 연구가 제공됩니다.', 0, 0),
       ('오염된 피', '저그 전용',
        '플레이그에 걸린 적은 체력이 없으면 실드가 깎이고, 실드가 없으면 죽습니다. 아군/팀원은 피해를 안 받습니다. 플레이그에 걸린 아군/팀원/적이 죽으면 근처 9x9에 플레이그가 뿌려집니다.', 0,
        0),
       ('울트라 Risk', '저그 전용',
        '처음부터 울트라리스크를 자원 150/150에 생산할 수 있고 울트라 방2업, 발업이 완료됩니다. 대신 캐번 없이 생산할 때마다 무작위 유닛 또는 건물 1개가 파괴되고, 그 비용을 반환합니다.', 0,
        0),
       ('절단 쐐기', '저그 전용', '뮤탈리스크의 쿠션데미지가 감소하지 않는 대신 생산 비용과 시간이 10% 증가합니다. 가디언, 디바우러 변태를 할 수 없게 됩니다.', 0, 0),
       ('차세대 여왕', '저그 전용', '퀸이 감염된 케리건으로 교체됩니다. 감염된 케리건: 체력 200, 공격력 25, 시작마나 250. 클로킹, 인스네어, 스톰, 컨슘 가능.', 0, 0),
       ('콜로니 투하', '저그 전용',
        '레어가 있으면, 오버로드에서 버튼을 눌러 225미네랄과 오버로드를 둘 다 소모하고 그 위치에 성큰 1개, 스포어 1개를 설치할 수 있습니다. 설치는 지형과 건물에 겹쳐서 가능합니다.', 0, 0),
       ('크립 농장', '저그 전용', '크립 콜로니가 체력이 서서히 줄어들면서 자원을 생성합니다. (매 초 체력 -1, 미네랄 +1, 가스 +1) 어떤 이유로든 파괴되면 미네랄 +250.', 0, 0),
       ('하늘굴망', '저그 전용', '클로킹된 갈색 커널이 주어집니다. 오버로드를 뽑으면 그 커널의 출구가 됩니다.', 0, 0),
       ('하이브 저그', '저그 전용', '해처리가 하이브로 변합니다.', 0, 0),
       ('콩 심은 데 콩 난다', '저그 전용', '버로우한 유닛이 30초마다 자기 비용의 절반을 소비하고 같은 유닛을 만듭니다. 버로우업이 제공됩니다.(자원이 모자라면 기다렸다가 자원이 생길 때 만듦)',
        0, 0),
       ('토마토 포', '저그 전용', '디파일러가 선딜레이 없는 야마토 포를 쏠 수 있고 킬을 낼 때마다 에너지 75를 돌려받습니다. 레어가 있으면 디파일러 마운드를 지을 수 있습니다.', 0, 0),
       ('유전자 몰빵', '저그 전용', '모든 저그 이속,공속,공방업효과가 뮤탈리스크에게도 적용됩니다.', 0, 0),
       ('바퀴', '저그 전용',
        '히드라 덴이 있으면 라바가 바퀴로 변이할 수 있습니다. 바퀴: 체력 145(대형), 지상 공격력 16(+2)(일반형), 사거리 4, 러커 이속. 연구 없이 버로우 가능. 버로우 중 체력 재생 증가 & 저속 이동.',
        0, 0),
       ('감염된 스캐럽', '프로토스 전용', '스캐럽이 터진 자리에 인페스티드 테란이 생깁니다.(수명 5초)', 0, 0),
       ('걸리버', '프로토스 전용',
        '리버 이동 속도, 스캐럽 이동 속도, 스캐럽 생산 속도가 빨라지며, 스캐럽 발사 간격이 짧아지고 스캐럽이 지형과 장애물에 걸리지 않습니다. 스캐럽 수용력 업그레이드가 주어집니다.', 0, 0),
       ('광자 과충전', '프로토스 전용',
        '전력을 공급받는 실드 배터리에서 버튼을 눌러 주변 적을 자동 공격합니다. (75에너지, 12.5초 지속, 공 25, 일반형 지상 공중 단일 공격, 사거리 7, 마린 공속, 본인 본진/앞마당에서 10배 강화)',
        0, 0),
       ('네라짐 특공대', '프로토스 전용', '채팅에 탑승! 을 입력하면, 모든 다크 템플러가 커세어로 변합니다. 강하! 를 입력하면, 모든 커세어가 다크 템플러로 변합니다.', 0, 0),
       ('딥 다크 템플러', '프로토스 전용',
        '다크 아콘을 만들면 즉시 영웅 다크 템플러로 교체됩니다. 영웅 다크: 피드백, 마엘, 마컨 사용 가능. 공, 방, 실, 체: 다크 템플러의 2배. 에너지 초깃값 및 회복 속도: 다크 아콘의 2배.',
        0, 0),
       ('똑똑한 드라군 피닉스', '프로토스 전용', '드라군의 사거리가 8이 되고 공격 속도가 조금 더 빨라지지만 2칸 이내를 때릴 수 없게 됩니다.', 0, 0),
       ('마법(물리)', '프로토스 전용', '하이 템플러가 마법을 못 쓰는 대신 강력한 지상 공격을 합니다. (공격력 70, 폭발형, 체력 160, 속업 벌처 이동속도)', 0, 0),
       ('문워크 광전사', '프로토스 전용', '질럿의 사거리가 2고, 이동 중 공격이 가능합니다. 질럿의 비용과 생산시간이 25% 증가합니다.', 0, 0),
       ('배보다 배꼽이 더 크다', '프로토스 전용', '캐리어 외형 및 속도가 인터셉터가 됩니다. 인터셉터 외형이 거대해지며, 사출 속도가 늘어나고, 5초당 1개씩 자동으로 충전됩니다.', 0, 0),
       ('보호막은 나약한 자들이나 쓰는 것', '프로토스 전용',
        '프로브, 인터셉터 외 유닛의 실드가 실드4 -> 체력3 비율로 추가 체력이 됩니다. 실드 배터리나 자연 회복 등으로 오르는 실드도 전부 추가 체력이 됩니다.', 0, 0),
       ('불사조', '프로토스 전용',
        '스카우트 대신 불사조를 뽑을 수 있습니다. 불사조: 실/체 60/120 (소형), 공격력 20 (진동형, 공중만), 사거리 2 (스카우트 시야업시 +2), 이동 중 공격. 중력자 광선으로 지상유닛 띄우기 가능.',
        0, 0),
       ('사이오닉 장풍', '프로토스 전용', '아콘의 사거리가 8입니다. 게이트웨이에서 아콘을 직접 뽑을 수 있습니다. (100/200으로 뽑을 수 있음)', 0, 0),
       ('실체화', '프로토스 전용', '할루시네이션이 수명 4분의 정상 유닛으로 변경됩니다.(하템 제외) 템플러 할루시 업, 마나업이 완료됩니다.', 0, 0),
       ('이야 흰색 더블넥서스 가네', '프로토스 전용', '본진에 넥서스 2개와 100미네랄로 시작합니다. 넥서스를 완성할 때마다 600 미네랄을 얻습니다.', 0, 0),
       ('중국산 배터리', '프로토스 전용',
        '실드 배터리가 파괴되면, 상하좌우 1칸 이내의 유닛과 건물을 모두 파괴하고, 50 미네랄을 환불받습니다. 실드 배터리를 파일론 없이도, 크립 위에도 지을 수 있습니다.', 0, 0),
       ('중재는 이렇게 하는거지', '프로토스 전용',
        '아비터 연구가 제공되고 기본 공격으로 사이오닉 스톰을 씁니다. 아비터의 요구 사항이 템플러 아카이브스입니다. 아비터는 본인 스톰에 면역이고, 스톰은 중첩 가능합니다.', 0, 0),
       ('차원 관문', '프로토스 전용', '배터리 대신 차원 관문을 지을 수 있습니다(150미네랄, 코어 필요). 차원 관문은 파일론 범위 내에 질럿과 드라군을 소환할 수 있습니다. (쿨타임 없음)', 0,
        0),
       ('차원장인 프로브', '프로토스 전용',
        '특정 건물을 3개 지으면, 관련 연구가 완료된 유닛으로 변합니다. 3서포트베이 → 3리버, 3옵저버토리 → 6옵저버, 3템카이브 → 3하템3닥템, 3플릿비콘 → 3캐리어, 3트라이뷰널 → 3아비터',
        0, 0),
       ('천지스톰', '프로토스 전용', '하이 템플러의 사이오닉 스톰 범위가 가로, 세로 각각 약 3배가 됩니다. 또한 내 하이 템플러는 사이오닉 스톰 마법에 면역이며 사이오닉 스톰 연구가 완료됩니다.',
        0, 0),
       ('케이다린 초석', '프로토스 전용',
        '포톤 캐논을 100 미네랄 100 가스를 소모하여 케이다린 초석으로 강화할 수 있습니다. (공격력 20→100, 사거리 7→13, 체력 100→200, 공격 속도 느림)', 0, 0),
       ('탈다림 전사들', '프로토스 전용', '질럿과 드라군이 스팀팩을 쓸 수 있습니다. 시타델 오브 아둔에서 스팀팩을 개발할 수 있습니다.', 0, 0),
       ('포토 겹치기', '프로토스 전용', '포톤 캐논을 완성할 때마다, 그 자리에 겹쳐서 캐논이 더 생성됩니다. 생성되는 개수는 시간이 갈 수록 점점 많아집니다.', 0, 0),
       ('하늘의 왕자', '프로토스 전용', '스카우트가 지상으로도 미사일 공격을 합니다. 스카우트 속도, 시야 업그레이드가 완료되고, 디텍터 기능이 추가되며, 공격 발사각이 넓어집니다.', 0, 0),
       ('캐리어 주포', '프로토스 전용', '인터셉터를 가진 캐리어가 직접 공격할 수 있습니다. (공격력 90(+5), 일반형 범위 공격, 사거리 8, 드라군 공격 속도)', 0, 0),
       ('제리', '프로토스 전용', '파일론이 무료이고 체력이 20/20인 상태로 즉시 완성됩니다.', 0, 0);