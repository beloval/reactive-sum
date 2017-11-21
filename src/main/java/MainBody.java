import rx.Observable;
import rx.observables.ConnectableObservable;

public class MainBody {
    public static void main(String[] args) throws Exception {
        ConnectableObservable<String> input = from(System.in); //1

        Observable<Double> a = varStream("a", input);//2
        Observable<Double> b = varStream("b", input);

        ReactiveSum = sum = new ReactiveSum(a, b);//3
        input.connect();//4
    }
}
