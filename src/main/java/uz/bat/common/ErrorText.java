package uz.bat.common;


public enum ErrorText
{
    REMOVE_ERROR( "1", "Запись не удаляется! Проверьте зависимости!" ),
    REQUEST_ERROR ( "2", "Missing mandatory parameters or request syntax error" ),
    DATA_INTEGRITY_VIOLATION_ERROR ( "3", "Data integrity violation error" ),
    NO_DATA_FOUND( "4", "Requested data not found" )
    ;


    ErrorText(String error, String code)
    {
        this.error = error;
        this.code = code;
    }

    private String error;
    private String code;

    public String getError()
    {
        return error;
    }

    public void setError(String error)
    {
        this.error = error;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
}
