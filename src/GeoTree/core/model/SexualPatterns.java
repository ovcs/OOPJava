package GeoTree.core.model;

/**
 * Каждое существо, которое является наследником от кого-то появилось на свет, благодаря такому же
 * потомку (HERMAPHRODITE), или от двух родителей, где один является носителем генетической
 * информации (INSEMINATE), а второй - вынашивает яйцеклетку (INCUBATE). Последний же (STERILE) является
 * объектом, который относится к отсутствию (None) продолжать род.
 */
public enum SexualPatterns {
    INSEMINATE,
    INCUBATE,
    HERMAPHRODITE,
    STERILE
}
