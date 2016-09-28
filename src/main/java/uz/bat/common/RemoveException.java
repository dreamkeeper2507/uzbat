package uz.bat.common;

public class RemoveException extends  Exception
{
    public RemoveException()
    {

        super("Удаление не возможно! Проверьтие зависимости!");
    }
}
