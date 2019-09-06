package zzas.chen.ZZASdao;

public class TB_AA_SERVICE {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    private int id;
    private int service_id;
    private int total_sum;
    private String creattime;
}
