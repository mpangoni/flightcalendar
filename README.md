


<h2>Português<h2>

<h2>Introdução</h2>

O conteúdo está estruturado em 3 pastas:

<ol>
    <li>Sources- contém os fontes da aplicação.
    <li>Documentation - contem os diagramas e outras informações.
    <li>Distribution - contém uma versão compildada desta aplicação.
</ol>

Para desenvolver esta aplicação, estão sendo usados os seguintes frameworks:

<ul>
    <li> Bootstrap 4.x - Para prover a interface Web e a responsividade em diferentes devices/tamanhos de tela;
    <li> JQuery 3.3.1 -
    <li> JQuery UI 1.7 - Prove o "datepicker" usado na interface de pesquisa de vôos;
    <li> Material Desing by Google - Icones;
    <li> Spring-Boot - Toda a Infra estrutura de Application Server e REST;
    <li> HSQLDB - Já disponivel no Spring-Boot;
    <li> Maven - Para  Ciclo de Compilações.
</ul>

<h3>Filosofia de desenvolvimento</h3>
    
O Desenvolvimento desta aplicação está pautado em uma Arquitetura DDD. 

O Integração entre a Interface Web e a Aplicação se dá apenas por Chamadas REST feitas por AJAX. Isto nos leva as seguintes premissas:

<ul>
<li> Não há paginas web dinâmicas neste projeto. Toda a informação apresentada ou é estática, ou provem de chamadas AJAX que retornam apenas JSON, que são interpretados por JavaScripts.
 
<li> A Aplicação Java apenas disponibiliza funcionalidas em REST que devem retornar apenas JSON e nenhum outro formato.
</ul>

Outro ponto com relação ao desenvolvimento da Aplicação, é utilizar apenas Frameworks e APIs fornecidos pelo Spring-Boot. Exemplos disto é usar o <i>Jakson</i> para consumir os JSONs com informações aereas provenientes da <b>SABRE</b> , e usar o HSQLDB já embutido como banco de dados.
