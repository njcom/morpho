<?php declare(strict_types=1);
namespace Morpho\Test\Unit\App\Web\ActionMetaProviderTest;

use Morpho\App\Web\Controller;

/**
 * @noRoutes
 */
class NoRoutesController extends Controller {
    public function doSomething() {
    }
}
