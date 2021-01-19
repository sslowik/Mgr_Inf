namespace FactoryPattern.AbstractFactory
{
    using FactoryPattern.Model;

    public interface IItalianCuisine
    {
        APasta MakePasta();
        APizza MakePizza();
    }
}
