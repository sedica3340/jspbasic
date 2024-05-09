<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%
    String name = request.getParameter("n");
    int age = Integer.parseInt(request.getParameter("a"));
%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Document</title>
    </head>
    <body>

        <% for(int i = 0; i < 3; i++) { %>
        <p>
            국회는 정부의 동의없이 정부가 제출한 지출예산 각항의 금액을
            증가하거나 새 비목을 설치할 수 없다.
        </p>
        <% } %>
        <h1><%= name %>, <%= age %>살!</h1>
        <p>
            공무원의 신분과 정치적 중립성은 법률이 정하는 바에 의하여 보장된다.
        </p>

        <p>
            국회의원의 선거구와 비례대표제 기타 선거에 관한 사항은 법률로
            정한다.
        </p>

        <p>
            대통령·국무총리·국무위원·행정각부의 장·헌법재판소
            재판관·법관·중앙선거관리위원회 위원·감사원장·감사위원 기타 법률이
            정한 공무원이 그 직무집행에 있어서 헌법이나 법률을 위배한 때에는
            국회는 탄핵의 소추를 의결할 수 있다.
        </p>

        <p>
            사법권은 법관으로 구성된 법원에 속한다. 국가는 청원에 대하여 심사할
            의무를 진다.
        </p>

        <p>
            국회의원이 회기전에 체포 또는 구금된 때에는 현행범인이 아닌 한
            국회의 요구가 있으면 회기중 석방된다.
        </p>

        <p>
            모든 국민은 건강하고 쾌적한 환경에서 생활할 권리를 가지며, 국가와
            국민은 환경보전을 위하여 노력하여야 한다.
        </p>

        <p>
            국무총리는 국회의 동의를 얻어 대통령이 임명한다. 훈장등의 영전은
            이를 받은 자에게만 효력이 있고, 어떠한 특권도 이에 따르지 아니한다.
        </p>

        <p>
            명령·규칙 또는 처분이 헌법이나 법률에 위반되는 여부가 재판의 전제가
            된 경우에는 대법원은 이를 최종적으로 심사할 권한을 가진다.
        </p>

        <p>
            이 헌법시행 당시의 법령과 조약은 이 헌법에 위배되지 아니하는 한 그
            효력을 지속한다.
        </p>
        <script>
            const $pList = document.querySelectorAll("p");
            let i = 1;
            $pList.forEach(($p) => {
                if (i % 3 === 1) {
                    $p.style.color = "red";
                } else if (i % 3 === 2) {
                    $p.style.color = "green";
                } else {
                    $p.style.color = "blue";
                }
                i++;
            });
            const $h1 = document.querySelector("h1");
            $h1.style.color = "#ff8342";
            $h1.style.fontSize = "55px";
        </script>
    </body>
</html>
