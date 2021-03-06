import rx.Observable;
import rx.Observer;
import rx.functions.Func2;

public final class ReactiveSum implements Observer<Double> { //1

    private double sum;
    public ReactiveSum(Observable<Double> a, Observable<Double> b) {
        this.sum = 0;
        Observable.combineLatest(a, b, new Func2<Double, Double, Double>() { // (5)
            public Double call(Double a, Double b) {
                return a + b;
            }
        }).subscribe(this); // (6)
    }
    @Override
    public void onCompleted() {
        System.out.println("Exiting last sum was : " + this.sum); //(4)
    }

    @Override
    public void onError(Throwable e) {
        System.err.println("Got an error!"); // (3)
        e.printStackTrace();
    }
    @Override
    public void onNext(Double sum) {
        this.sum = sum;
        System.out.println("update : a + b = " + sum); // (2)
    }

    /*
    public static void reactiveSum(
                Observable<Double> a,
                Observable<Double> b) {
                Observable
                          .combineLatest(a, b, (x, y) -> x + y) // (1)
                          .subscribe( // (2)
            sum -> System.out.println("update : a + b = " + sum),
            error -> {
                        System.out.println("Got an error!");
                        error.printStackTrace();
                        },
                        () -> System.out.println("Exiting...")
                        );
}
     */
    /*
                   public class ReactiveSum { // (1)
                        private BehaviorSubject<Double> a = BehaviorSubject.create(0.0);
                        private BehaviorSubject<Double> b = BehaviorSubject.create(0.0);
                        private BehaviorSubject<Double> c = BehaviorSubject.create(0.0);
                        public ReactiveSum() { // (2)
                        Observable.combineLatest(a, b, (x, y) -> x + y).subscribe(c);
                        }
                        public double getA() { // (3)
                        return a.getValue();
                        }
                        public void setA(double a) {
                        this.a.onNext(a);
                        }
                        public double getB() {
                        return b.getValue();
                        }
                        public void setB(double b) {
                        this.b.onNext(b);
                        }
                        public double getC() { // (4)
                        return c.getValue();
                        }
                        public Observable<Double> obsC() {
                        return c.asObservable();
                        }
                        }
     */
}


