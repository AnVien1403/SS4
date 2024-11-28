<!DOCTYPE html>
<html>
<head>
    <title>Danh sách cầu thủ</title>
</head>
<body>
    <h1>Danh sách cầu thủ</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Họ và tên</th>
                <th>Tuổi</th>
                <th>Chỉnh sửa</th>
                <th>Xóa</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="player" items="${players}">
                <tr>
                    <td>${player.playerId}</td>
                    <td>${player.name}</td>
                    <td>${player.fullName}</td>
                    <td>${player.age}</td>
                    <td><a href="edit?playerId=${player.playerId}">Sửa</a></td>
                    <td><a href="delete?playerId=${player.playerId}">Xóa</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Thêm người chơi mới</h2>
    <form action="players" method="post">
        Tên: <input type="text" name="name"><br>
        Họ và tên: <input type="text" name="fullName"><br>
        Tuổi: <input type="text" name="age"><br>
        ID chỉ số: <input type="text" name="indexId"><br>
        <input type="submit" value="Thêm">
    </form>
</body>
</html>
