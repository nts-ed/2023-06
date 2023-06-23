-- symmetrix_dbshare という名前databaseを作成してください！！！！

-- 1 社員情報
create table t_employees
(
    EMPLOYEES_ID   int auto_increment comment '社員ID'
        primary key,
    PASSWORD       varchar(15) default '123456' not null comment 'パスワード',
    EMPLOYEES_NAME varchar(100)                 not null comment '社員名',
    AGE            int                          null comment '年齢',
    GENDER         int                          null comment '性別 １、男性　0、女性',
    PHONE_NUMBER   varchar(15)                  null comment '電話番号',
    EMAIL          varchar(50)                  null comment 'メール',
    ENTRY_DATE     date                         null comment '入社日',
    POSITION_FLG   int                          null comment '職位フラグ  1、管理者　0、一般社員',
    DEPT_ID        int                          null comment '所属部門ID',
    DEL_FLG        int                          null comment '削除フラグ 1、削除権ある 0、なし',
    CREATE_DATE    date                         null comment '作成日時',
    CREATE_USERID  int                          null comment '作成者',
    UPDATE_DATE    date                         null comment '更新日時',
    UPDATE_USERID  int                          null comment '更新者'
)
    comment '社員情報';


-- 2 勤怠実績
create table t_attendance
(
    EMPLOYEES_ID       int          not null comment '社員ID',
    ATTENDANCE_DATE    varchar(20)  not null comment '日付'
        primary key,
    START_TIME         varchar(5)   not null comment '出勤時間',
    END_TIME           varchar(5)   not null comment '出勤時間',
    REST_HOURS_DAY     double(4, 1) null comment '休憩時間',
    WORKING_HOURS_DAY  double(4, 1) null comment '実働時間',
    OVERTIME_HOURS_DAY double(4, 1) null comment '残業時間',
    ABSENCE_HOURS_DAY  double(4, 1) null comment '欠勤時間',
    STATUS_ID          int          null comment '勤務状態ID',
    WORK_CONTENT       varchar(200) null comment '作業内容',
    DEL_FLG            int          null comment '削除フラグ  1、削除権ある　0、なし',
    CREATE_DATE        date         null comment '作成日時',
    CREATE_USERID      int          null comment '作成者',
    UPDATE_DATE        date         null comment '更新日時',
    UPDATE_USERID      int          null comment '更新者',
    PLUS_CONTENT       varchar(200) null comment '備考'
)
    comment '勤怠実績';



-- 3 勤怠年月
create table t_attendance_ym
(
    EMPLOYEES_ID         int          not null comment '社員ID',
    ATTENDANCE_YM        varchar(10)  not null comment '勤怠年月'
        primary key,
    ALLDAYS              int          null comment '営業日数',
    WORKDAYS             int          null comment '出勤日数',
    RESTDAYS             int          null comment '欠勤日数',
    WORKING_HOURS_MONTH  double(4, 1) null comment '実働時間(月)',
    REST_HOURS_MONTH     double(4, 1) null comment '休憩時間(月)',
    ABSENCE_HOURS_MONTH  double(4, 1) null comment '欠勤時間(月)',
    OVERTIME_HOURS_MONTH double(4, 1) null comment '残業時間(月)',
    APPLY_ID             int          null comment '申請状態ID 0、未提出　１、申請中　２、承認　３、却下',
    COMMENT              varchar(400) null comment 'コメント(月)',
    DEL_FLG              int          null comment '削除フラグ 1、削除権ある　0、なし',
    CREATE_DATE          date         null comment '作成日時',
    CREATE_USERID        int          null comment '作成者',
    UPDATE_DATE          date         null comment '更新日時',
    UPDATE_USERID        int          null comment '更新者'
)
    comment '勤怠年月';


-- 4 カレンダー
create table t_calendar
(
    CALENDAR_DATE date       not null comment '日付'
        primary key,
    WEEKDAY       varchar(3) null comment '曜日',
    HOLIDAY_FLG   int        null comment '休日フラグ １、休日　0、ではない',
    DEL_FLG       int        null comment '削除フラグ 1、削除権ある　0、なし',
    CREATE_DATE   date       null comment '作成日時',
    CREATE_USERID int        null comment '作成者',
    UPDATE_DATE   date       null comment '更新日時',
    UPDATE_USERID int        null comment '更新者'
)
    comment 'カレンダー';



-- 5 出勤状態
create table t_status
(
    STATUS_ID     int auto_increment comment '状態ID'
        primary key,
    STATUS_NAME   varchar(20) not null comment '状態名称',
    DEL_FLG       int         null comment '削除フラグ 1、削除権ある　0、なし',
    CREATE_DATE   date        null comment '作成日時',
    CREATE_USERID int         null comment '作成者',
    UPDATE_DATE   date        null comment '更新日時',
    UPDATE_USERID int         null comment '更新者'
)
    comment '出勤状態';



-- 6 部門情報
create table t_dept
(
    DEPT_ID       int auto_increment comment '部門ID'
        primary key,
    DEPT_NAME     varchar(10) not null comment '部門名',
    DEL_FLG       int         null comment '削除フラグ 1、削除権ある  0、なし',
    CREATE_DATE   date        null comment '作成日時',
    CREATE_USERID int         null comment '作成者',
    UPDATE_DATE   date        null comment '更新日時',
    UPDATE_USERID int         null comment '更新者'
)
    comment '部門情報';
