package com.sym.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 勤怠年月
 * @TableName t_attendance_ym
 */
@TableName(value ="t_attendance_ym")
@Data
public class AttendanceYm implements Serializable {
    /**
     * 勤怠年月
     */
    @TableId
    private String attendanceYm;

    /**
     * 社員ID
     */
    private Integer employeesId;

    /**
     * 営業日数
     */
    private Integer alldays;

    /**
     * 出勤日数
     */
    private Integer workdays;

    /**
     * 欠勤日数
     */
    private Integer restdays;

    /**
     * 実働時間(月)
     */
    private Double workingHoursMonth;

    /**
     * 休憩時間(月)
     */
    private Double restHoursMonth;

    /**
     * 欠勤時間(月)
     */
    private Double absenceHoursMonth;

    /**
     * 残業時間(月)
     */
    private Double overtimeHoursMonth;

    /**
     * 申請状態ID 0、未提出　１、申請中　２、承認　３、却下
     */
    private Integer applyId;

    /**
     * コメント(月)
     */
    private String comment;

    /**
     * 削除フラグ 1、削除権ある　0、なし
     */
    private Integer delFlg;

    /**
     * 作成日時
     */
    private Date createDate;

    /**
     * 作成者
     */
    private Integer createUserid;

    /**
     * 更新日時
     */
    private Date updateDate;

    /**
     * 更新者
     */
    private Integer updateUserid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AttendanceYm other = (AttendanceYm) that;
        return (this.getAttendanceYm() == null ? other.getAttendanceYm() == null : this.getAttendanceYm().equals(other.getAttendanceYm()))
            && (this.getEmployeesId() == null ? other.getEmployeesId() == null : this.getEmployeesId().equals(other.getEmployeesId()))
            && (this.getAlldays() == null ? other.getAlldays() == null : this.getAlldays().equals(other.getAlldays()))
            && (this.getWorkdays() == null ? other.getWorkdays() == null : this.getWorkdays().equals(other.getWorkdays()))
            && (this.getRestdays() == null ? other.getRestdays() == null : this.getRestdays().equals(other.getRestdays()))
            && (this.getWorkingHoursMonth() == null ? other.getWorkingHoursMonth() == null : this.getWorkingHoursMonth().equals(other.getWorkingHoursMonth()))
            && (this.getRestHoursMonth() == null ? other.getRestHoursMonth() == null : this.getRestHoursMonth().equals(other.getRestHoursMonth()))
            && (this.getAbsenceHoursMonth() == null ? other.getAbsenceHoursMonth() == null : this.getAbsenceHoursMonth().equals(other.getAbsenceHoursMonth()))
            && (this.getOvertimeHoursMonth() == null ? other.getOvertimeHoursMonth() == null : this.getOvertimeHoursMonth().equals(other.getOvertimeHoursMonth()))
            && (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getCreateUserid() == null ? other.getCreateUserid() == null : this.getCreateUserid().equals(other.getCreateUserid()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getUpdateUserid() == null ? other.getUpdateUserid() == null : this.getUpdateUserid().equals(other.getUpdateUserid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendanceYm() == null) ? 0 : getAttendanceYm().hashCode());
        result = prime * result + ((getEmployeesId() == null) ? 0 : getEmployeesId().hashCode());
        result = prime * result + ((getAlldays() == null) ? 0 : getAlldays().hashCode());
        result = prime * result + ((getWorkdays() == null) ? 0 : getWorkdays().hashCode());
        result = prime * result + ((getRestdays() == null) ? 0 : getRestdays().hashCode());
        result = prime * result + ((getWorkingHoursMonth() == null) ? 0 : getWorkingHoursMonth().hashCode());
        result = prime * result + ((getRestHoursMonth() == null) ? 0 : getRestHoursMonth().hashCode());
        result = prime * result + ((getAbsenceHoursMonth() == null) ? 0 : getAbsenceHoursMonth().hashCode());
        result = prime * result + ((getOvertimeHoursMonth() == null) ? 0 : getOvertimeHoursMonth().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getCreateUserid() == null) ? 0 : getCreateUserid().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getUpdateUserid() == null) ? 0 : getUpdateUserid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attendanceYm=").append(attendanceYm);
        sb.append(", employeesId=").append(employeesId);
        sb.append(", alldays=").append(alldays);
        sb.append(", workdays=").append(workdays);
        sb.append(", restdays=").append(restdays);
        sb.append(", workingHoursMonth=").append(workingHoursMonth);
        sb.append(", restHoursMonth=").append(restHoursMonth);
        sb.append(", absenceHoursMonth=").append(absenceHoursMonth);
        sb.append(", overtimeHoursMonth=").append(overtimeHoursMonth);
        sb.append(", applyId=").append(applyId);
        sb.append(", comment=").append(comment);
        sb.append(", delFlg=").append(delFlg);
        sb.append(", createDate=").append(createDate);
        sb.append(", createUserid=").append(createUserid);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateUserid=").append(updateUserid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}