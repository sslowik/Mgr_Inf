namespace FactoryPattern.FactoryMethods
{
    using FactoryPattern.Model;

    public interface IPrepareFood
    {
        AFood PrepareFood();
    }
}
