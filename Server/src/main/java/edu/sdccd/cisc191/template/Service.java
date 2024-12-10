package edu.sdccd.cisc191.template;

public abstract class Service
{
    private String serviceName;

    public Service(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName()
    {
        this.serviceName = serviceName;
    }

    public abstract void executeService();
}
