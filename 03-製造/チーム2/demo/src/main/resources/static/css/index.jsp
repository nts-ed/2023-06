<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>勤怠管理(日別)</title>
    <style>
        .button {
            display: inline-block;
            padding: 5px 10px;
            margin: 2px;
            background-color: #4CAF50;
            color: white;
            border-radius: 4px;
            border: none;
            text-decoration: none;
            font-size: 14px;
            cursor: pointer;
        }

        .button-container {
            text-align: center;
            margin-bottom: 10px;
        }

        .checkbox-cell {
            text-align: center;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">勤怠管理(日別)</h1>

    <div class="button-container">
        <button class="button">追加</button>
        <button class="button" onclick="deleteSelected()">一括削除</button>
        <button class="button">戻る</button>
    </div>

    <table style="margin: 0 auto;">
        <tr>
            <td>
                <table border="1" style="margin: 0;">
                    <tr>
                        <th>社員ID</th>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th>氏名</th>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th>所属</th>
                        <td>&nbsp;</td>
                    </tr>
                    <tr>
                        <th>年度</th>
                        <td>&nbsp;</td>
                    </tr>
                </table>
            </td>
            <td>
                <table border="1" style="margin: 0;">
                    <tr>
                        <th>選択</th>
                        <th>日付</th>
                        <th>曜日</th>
                        <th>勤務区分</th>
                        <th>出勤時間</th>
                        <th>退勤時間</th>
                        <th>休憩時間</th>
                        <th>作業時間</th>
                        <th>残業時間</th>
                        <th>作業内容</th>
                        <th>修正</th>
                        <th>削除</th>
                    </tr>
                    <tr>
                        <td class="checkbox-cell"><input type="checkbox"></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>
                            <button class="button">修正</button>
                        </td>
                        <td>
                            <button class="button">削除</button>
                        </td>
                    </tr>
                    <!-- 添加更多的数据行 -->
                    <tr>
                        <td class="checkbox-cell"><input type="checkbox"></td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>
                            <button class="button">修正</button>
                        </td>
                        <td>
                            <button class="button">削除</button>
                        </td>
                    </tr>
                    <!-- 添加更多的数据行 -->
                </table>
            </td>
        </tr>
    </table>

    <script>
        function deleteSelected() {
            var checkboxes = document.querySelectorAll('input[type="checkbox"]:checked');
            checkboxes.forEach(function(checkbox) {
                var row = checkbox.parentNode.parentNode;
                row.parentNode.removeChild(row);
            });
        }
    </script>
</body>
</html>
