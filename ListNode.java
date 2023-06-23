import org.w3c.dom.NodeList;


/*
 * Prova da Unidade 1 de Programação Estruturada
 * ALuna: Liza Alexandra Vieira Magalhães de Azevedo
 */

public class ListNode {

    public Node refNode;
    public int length = 0;

    public void add(String content) {

        Node newNode = new Node();
        newNode.content = content;

        newNode.prox = this.refNode;
        this.refNode = newNode;
        this.length++;
    }

    public Node remove() {

        if (this.refNode == null) {
            return null;
        }
        this.length--;
        Node rem = this.refNode;
        this.refNode = this.refNode.prox;

        return null;
    }

    /*
     * Imprime a lista de conteúdos
     */
    public void imprimir() {
        System.out.println("Lista de Conteúdos:");
        for (int i = 0; i < this.length; i++) {
            System.out.println(this.getNode(i).content);
        }
    }

    /*
     * Retorna uma lista invertida da lista original
     */
    public ListNode invert() {
        ListNode invertedList = new ListNode();
        Node current = this.refNode;

        while (current != null) {
            invertedList.add(current.content);
            current = current.prox;
        }
        return invertedList;
    }

    /*
     * Adiciona o conteúdo na posição i, caso não exista adiciona no início.
     */
    public void addFirst(String content, int i) {
        if (i <= 0) {
            add(content);
        } else {
            Node newNode = getNode(i - 1);
            if (newNode == null) {
                add(content);
                return;
            }
            Node addNode = new Node();
            addNode.content = content;
            addNode.prox = newNode.prox;
            newNode.prox = addNode;
            this.length++;
        }
    }

    /*
     * Subtitui o conteúdo do node i, caso não exista não faz nada
     */
    public void replace(String content, int i) {
        Node n = getNode(i);
        if(n != null){
            n.content = content;
        }
        else{
            return;
        }
    }

    /*
     * Retorna uma nova lista com a quantidade de elementos de acordo com length e
     * todos os elementos com o mesmo content.
     */
    public ListNode newList(int length, String content) {
        ListNode newList = new ListNode();
        for (int i = 0; i < length; i++) {
            newList.add(content);
        }
        return newList;
    }

    /*
     * Retorna o node da posição i
     */
    public Node getNode(int i) {
        Node aux = this.refNode;
        int c = 0;
        while (aux != null) {
            if (c == i) {
                return aux;
            }
            aux = aux.prox;
            c++;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode list = new ListNode();
        list.add("Isau");
        list.add("Igor");
        list.add("Liza");
        list.add("Emanuel");
        list.add("Pedro");
        
        System.out.println("Lista original:");
        list.imprimir();

        System.out.println("Lista invertida:");
        ListNode invertedList = list.invert();
        invertedList.imprimir();

        System.out.println("Lista com adicao na posicao 0:");
        list.addFirst("Antonio", 0);
        list.imprimir();

        System.out.println("Lista com substituicao na posicao 1:");
        list.replace("Lucas", 1);
        list.imprimir();

        System.out.println("Nova lista criada:");
        ListNode newList = list.newList(6, "Teste");
        newList.imprimir();
    }
}